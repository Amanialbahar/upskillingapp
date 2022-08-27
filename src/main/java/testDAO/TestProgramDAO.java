package testDAO;

import java.io.DataOutput;
import java.util.List;


import Bean.Program;
import Bean.School;
import DAO.ProgramDAO;
import DAO.SchoolDAO;

public class TestProgramDAO {

	public static void main(String[] args) {

		int row;
		ProgramDAO dao = new ProgramDAO();
//		Program program = new Program();

//		// **Delete**
//		System.out.println("---------------------------------");
		row = dao.delete(20); 
		System.out.println(row + " deleted");

		// **insert**
		System.out.println("---------------------------------");
		 Program program=new Program(20,"Computer Information System", "انظمة معلومات حاسوبية");
		 program.setSchool(new School(2));
		row=dao.insert(program);
		System.out.println(row + " inserted"); 

//		// **update**
//		System.out.println("---------------------------------");
		program.setProgram_aname("aaaa");
		program.setProgram_ename("aaaa");
////		program.setProgram_id("");
		row=dao.update(program);
		System.out.println(row + "updated"); 

		// **Select all**
		System.out.println("---------------------------------");

		List<Program> programTable = dao.selectall();
		System.out.println(programTable);

		List<String> table = dao.selectSchools();
		System.out.println(table);
		
		List<String> proTable =dao.getProgBySchool(1);
		System.out.println(proTable);
		List<String> proTable1 =dao.getProgBySchool(2);
		System.out.println(proTable1);
		List<String> proTable11 =dao.getProgBySchool(3);
		System.out.println(proTable11);
	}

}
