package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bean.TrainingCourse;
import Database.Databasea;

public class TrainingCourseDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private ArrayList<TrainingCourse> trainingCourseTable;
	private int row;

	// **select by Id **

	public TrainingCourse selectbyId(int course_id) {
		TrainingCourse trainingcourse = null;

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select course_id, course_aname, course_ename, max_students, short_desc, detailed_desc from training_course where course_id=?");
			ps.setInt(1, course_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				trainingcourse = new TrainingCourse(rs.getInt("course_id"), rs.getString("course_aname"),
						rs.getString("course_ename"), rs.getInt("max_students"), rs.getString("short_desc"),
						rs.getString("detailed_desc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return trainingcourse;
	}

	// ** select max id**
	private static int selectMaxId(Connection connection) {
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		try {
			ps2 = connection.prepareStatement("select nvl(max(course_id),0) AS course_id from training_course");
			rs2 = ps2.executeQuery();

			if (rs2.next()) {
				return rs2.getInt("course_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
			Databasea.close(rs2);
			Databasea.close(ps2);
		}

		return 0;
	}

// **Select All**

	public List<TrainingCourse> selectAll() {

		try {
			db = new Databasea();
			trainingCourseTable = new ArrayList<TrainingCourse>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select course_id, course_aname, course_ename, max_students, short_desc, detailed_desc from training_course order by course_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				TrainingCourse trainingcourse = new TrainingCourse(rs.getInt("course_id"), rs.getString("course_aname"),
						rs.getString("course_ename"), rs.getInt("max_students"), rs.getString("short_desc"),
						rs.getString("detailed_desc"));
				trainingCourseTable.add(trainingcourse);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return trainingCourseTable;
	}

	// **INSERT**
	public int insert(TrainingCourse trainingcourse) {

		try {

			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into training_course(course_id, course_aname, course_ename, max_students, short_desc, detailed_desc) values(?, ?, ?, ?, ?,?)");

			int counter = 1;
			int maxId = selectMaxId(connection);
			System.out.println(maxId);

			ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, trainingcourse.getCourse_aname());
			ps.setString(counter++, trainingcourse.getCourse_ename());
			ps.setInt(counter++, trainingcourse.getMax_stu());
			ps.setString(counter++, trainingcourse.getShort_desc());
			ps.setString(counter++, trainingcourse.getDetailed_desc());

			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);

		}
		return row;
	}

	// ** Update **

	public int update(TrainingCourse trainingCourse) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update training_course set course_aname= ?, course_ename= ?, max_students= ?, short_desc= ?, detailed_desc=?  where course_id = ?");

			int counter = 1;
			ps.setString(counter++, trainingCourse.getCourse_aname());
			ps.setString(counter++, trainingCourse.getCourse_ename());
			ps.setInt(counter++, trainingCourse.getMax_stu());
			ps.setString(counter++, trainingCourse.getShort_desc());
			ps.setString(counter++, trainingCourse.getDetailed_desc());
			ps.setInt(counter++, trainingCourse.getCourse_id());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return row;
	}

	// ** Delete**

	public int delete(int course_id) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete training_course where course_id= ?");
			ps.setInt(1, course_id);
			row = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return row;
	}

}
