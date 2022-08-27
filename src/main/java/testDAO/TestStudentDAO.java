package testDAO;

import java.util.Date;
import java.util.List;

import Bean.Program;
import Bean.School;
import Bean.Student;
import Bean.University;
import DAO.StudentDAO;

public class TestStudentDAO {

	public static void main(String[] args) {

		int row;
		StudentDAO dao = new StudentDAO();
		Student student = new Student();

		// **Delete**
		System.out.println("---------------------------------");

		row = dao.delete(4);
		System.out.println(row + " deleted");

		// **insert**
		System.out.println("---------------------------------");
		student = new Student(4, "اماني خضر", "Amani Khader", 2, "0795024180", "amanikh@yahoo.com", 3, 4, "V.Good",
				2013, 2);
		student.setProgram(new Program(1));
		student.setSchool(new School(2));
		student.setUniversity(new University(1));
		student.setBirthdate(new Date());

		row = dao.insert(student);
		System.out.println(row + " inserted");

		// **update**
		System.out.println("---------------------------------");
		student.setEmail("aa@gmail.com");
		student.setGraduate_year(2020);
		row = dao.update(student);
		System.out.println(row + " updated");


		// **Select all**
		System.out.println("---------------------------------");

		List<Student> StudentTable = dao.selectall();
		System.out.println(StudentTable);
	}

}
