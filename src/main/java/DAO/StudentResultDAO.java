package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Student;
import Bean.StudentResult;
import Bean.TrainingCourse;
import Database.Databasea;

public class StudentResultDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	private ArrayList<StudentResult> studentresulttable;

	// **Select all**

	public List<StudentResult> selectall() {
		List<StudentResult> studentresulttable = new ArrayList<StudentResult>();

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, course_id, english_mark, interview_mark, accepted_flag, notes from student_result order by student_id");

			rs = ps.executeQuery();

			while (rs.next()) {
				StudentResult studentresult = new StudentResult();

				StudentDAO studentdao = new StudentDAO();
				Student student = studentdao.selectbyId(rs.getInt("student_id"));
				studentresult.setStudent(student);

				TrainingCourseDAO trainingcoursedao = new TrainingCourseDAO();
				TrainingCourse course = trainingcoursedao.selectbyId(rs.getInt("course_id"));
				studentresult.setCourse(course);

				studentresult.setEnglish_mark(rs.getInt("english_mark"));
				studentresult.setInterview_mark(rs.getInt("interview_mark"));
				studentresult.setAccepted_flag(rs.getInt("accepted_flag"));
				studentresult.setNotes(rs.getString("notes"));

				studentresulttable.add(studentresult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return studentresulttable;
	}

	// **insert**

	public int insert(StudentResult studentresult) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_result (student_id, course_id, english_mark, interview_mark, accepted_flag, notes) values (?,?,?,?,?,?)");

			int counter = 1;

			ps.setInt(counter++, studentresult.getStudent().getStudent_id());
			ps.setInt(counter++, studentresult.getCourse().getCourse_id());
			ps.setInt(counter++, studentresult.getEnglish_mark());
			ps.setInt(counter++, studentresult.getInterview_mark());
			ps.setInt(counter++, studentresult.getAccepted_flag());
			ps.setString(counter++, studentresult.getNotes());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return row;
	}

	// **Update**

	public int update(StudentResult studentresult) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student_result set course_id=?, english_mark=?, interview_mark=?, accepted_flag=?, notes=? where student_id=? ");

			int counter = 1;

			ps.setInt(counter++, studentresult.getCourse().getCourse_id());
			ps.setInt(counter++, studentresult.getEnglish_mark());
			ps.setInt(counter++, studentresult.getInterview_mark());
			ps.setInt(counter++, studentresult.getAccepted_flag());
			ps.setString(counter++, studentresult.getNotes());
			ps.setInt(counter++, studentresult.getStudent().getStudent_id());

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

	public int delete(int student_id) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete student_result where student_id=?");
			ps.setInt(1, student_id);
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
