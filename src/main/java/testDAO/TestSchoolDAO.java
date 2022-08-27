package testDAO;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

import Bean.School;
import DAO.SchoolDAO;

public class TestSchoolDAO {

	public static void main(String[] args) {

		int row;
		SchoolDAO dao = new SchoolDAO();
		School school = new School();

		// **Delete**
		System.out.println("---------------------------------");

		row = dao.delete(2);
		System.out.println(row + " deleted");

		// **insert**
		System.out.println("---------------------------------");

		school = new School(2, "كلية تكنولوجيا المعلومات", "IT");
		row = dao.insert(school);
		System.out.println(row + " inserted");

		// **update**
		System.out.println("---------------------------------");

		school.setSchool_aname("كلية تكنولوجيا المعلومات");
		school.setSchool_ename("school of IT");
		row = dao.update(school);
		System.out.println(row + " updated");

		// **Select all**
		System.out.println("---------------------------------");

		List<School> schoolTable = dao.selectAll();
		System.out.println(schoolTable);

		SchoolDAO sdao = new SchoolDAO();
		List<School> table = sdao.selectSchools();
		System.out.println(table);

	}

}
