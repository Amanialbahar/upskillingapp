package testDAO;

import java.util.List;

import Bean.TrainingCourse;
import DAO.TrainingCourseDAO;

public class TestTrainigCourse {
	public static void main(String[] args) {

		int row;
		TrainingCourseDAO dao = new TrainingCourseDAO();
		TrainingCourse tc = new TrainingCourse();

		// **Delete**
		System.out.println("---------------------------------");
		row = dao.delete(3);
//
//		System.out.println(row + " deleted");

		// **insert**
		System.out.println("---------------------------------");

		// tc = new TrainingCourse(3, "لبرمجة في لغة الجافا", "Programing With Java",
		// "JSE, JSF, DESIGN PATTERN, JDBC",
		// "Introduction to Programing with Java, Java Standred Edition, Java Standerd
		// Faces, Java design Pattern such as Singleton, Factory, Facade, Proxy and DAO,
		// PRIMEFACES and Maven ");

//		tc = new TrainingCourse();
//		tc.setCourse_aname("البرمجة في لغة C#");
//		tc.setCourse_ename("Programing With C#");
//		tc.setShort_desc("");
//		tc.setDetailed_desc("");
		row = dao.insert(tc);
		System.out.println(row + " inserted");

		// **update**
//		System.out.println("---------------------------------");
//
//		tc.setCourse_ename("Programing With PHP");
//		tc.setCourse_aname("البرمجة في لغة PHP");
//		tc.setShort_desc("PHP is a server scripting language");
//		tc.setDetailed_desc(
//				"PHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages.PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft's ASP. you should have a basic understanding of the following: HTML,CSS and JavaScript");
//		row = dao.update(tc);
//		System.out.println(row + " updated");

		// **Select all**
		System.out.println("---------------------------------");

		List<TrainingCourse> tcTable = dao.selectAll();
		System.out.println(tcTable);

	}

}
