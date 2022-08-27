package testDAO;

import java.util.List;

import Bean.Student;
import Bean.StudentResult;
import Bean.TrainingCourse;
import DAO.StudentResultDAO;

public class TestStudentResultDAO {

	public static void main(String[] args) {

		int row;
		StudentResult studentResult = new StudentResult();
		StudentResultDAO dao = new StudentResultDAO();

		// **Delete**
		System.out.println("---------------------------------");

		row = dao.delete(4);
		System.out.println(row + " deleted");

		// **insert**
		System.out.println("---------------------------------");
		studentResult = new StudentResult(95, 90, 1, "there is no notes");
		studentResult.setStudent(new Student(4));
		studentResult.setCourse(new TrainingCourse(1));
		row = dao.insert(studentResult);
		System.out.println(studentResult.toString());
		System.out.println(row + " inserted");

		// **update**
		System.out.println("---------------------------------");
		studentResult.setAccepted_flag(2);
		row = dao.update(studentResult);
		System.out.println(row + " updated");

		// **Select all**
		System.out.println("---------------------------------");

		List<StudentResult> studentResultsTable = dao.selectall();
		System.out.println(studentResultsTable);

	}

}
