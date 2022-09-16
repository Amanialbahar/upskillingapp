package testDAO;

import java.util.List;

import Bean.Student;
import Bean.StudentTrainingCourse;
import Bean.TrainingCourse;
import DAO.StudentTrainingCourseDAO;

public class TestStuTrainingCourse {
	public static void main(String[] args) {

		int row;
		StudentTrainingCourse stu = new StudentTrainingCourse();
		StudentTrainingCourseDAO dao = new StudentTrainingCourseDAO();

		// **Delete**
		System.out.println("---------------------------------");

		//row = dao.delete(4);
		//System.out.println(row + " deleted");

		// **insert**
//		System.out.println("---------------------------------");
//		stu = new StudentTrainingCourse();
//		stu.setStudent(new Student(5));
//		stu.setCourse(new TrainingCourse(5));
//		stu.setPriority(3);
//		row = dao.insert(stu);
//		System.out.println(row + " Inserted");

		// **update**
		System.out.println("---------------------------------");

		//stu.setCourse(new TrainingCourse(3));
		//stu.setPriority(3);
		//row = dao.update(stu);
		//System.out.println(row + " updated");

		// **Select all**
		System.out.println("---------------------------------");

		List<StudentTrainingCourse> stuTable = dao.selectall();
		System.out.println(stuTable);
	}

}