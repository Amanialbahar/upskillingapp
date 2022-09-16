package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Student;
import Bean.StudentTrainingCourse;
import Bean.TrainingCourse;
import Database.Databasea;

public class StudentTrainingCourseDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	private ArrayList<StudentTrainingCourse> studentTrainingCourseTable;

	// **Select all**

	public List<StudentTrainingCourse> selectall() {
		studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();
		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, course_id, prioority from student_training_course order by student_id, prioority");
			rs = ps.executeQuery();

			while (rs.next()) {
				StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();

				StudentDAO studentdao = new StudentDAO();
				Student student = studentdao.selectbyId(rs.getInt("student_id"));
				studentTrainingCourse.setStudent(student);

				TrainingCourseDAO trainingcoursedao = new TrainingCourseDAO();
				TrainingCourse course = trainingcoursedao.selectbyId(rs.getInt("course_id"));
				studentTrainingCourse.setCourse(course);

				studentTrainingCourse.setPriority(rs.getInt("prioority"));

				studentTrainingCourseTable.add(studentTrainingCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return studentTrainingCourseTable;
	}

	// **insert**

	public int insert(StudentTrainingCourse studentTrainigCourse) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_training_course (student_id,course_id,prioority) values (?,?,?)");
			int counter = 1;
			ps.setInt(counter++, studentTrainigCourse.getStudent().getStudent_id());
			ps.setInt(counter++, studentTrainigCourse.getCourse().getCourse_id());
			ps.setInt(counter++, studentTrainigCourse.getPriority());

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

	public int update(StudentTrainingCourse studentTrainigCourse) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student_training_course set  course_id=? , prioority=? where student_id=? ");

			int counter = 1;

			ps.setInt(counter++, studentTrainigCourse.getCourse().getCourse_id());
			ps.setInt(counter++, studentTrainigCourse.getPriority());
			ps.setInt(counter++, studentTrainigCourse.getStudent().getStudent_id());

			row = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			ps = connection.prepareStatement("delete student_training_course where student_id= ?");
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
