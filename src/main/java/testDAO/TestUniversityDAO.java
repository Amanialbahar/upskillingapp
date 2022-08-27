package testDAO;

import java.util.List;

import Bean.University;
import DAO.UniversityDAO;

public class TestUniversityDAO {

	public static void main(String[] args) {

		int row;
		UniversityDAO dao = new UniversityDAO();
		University university = new University();

		// **Delete**
		System.out.println("---------------------------------");
		 row = dao.delete(2);
		 System.out.println(row + " deleted");
	
		// **insert**
		System.out.println("---------------------------------");

	
		  university = new University(2, "الجامعة الهاشمية", " ","");
		  row =dao.insert(university); 
		  System.out.println(row + " inserted");
		

		// **update**
		System.out.println("---------------------------------");
		

		university.setWebsite("www.hu.edu.jo");
		university.setUniversity_ename("Hasheimte University");
		  row =dao.update(university); 
		  System.out.println(row + " updated");
	
		// **Select all**
		System.out.println("---------------------------------");

		List<University> universityTable = dao.selectAll();
		System.out.println(universityTable);
	}

}
