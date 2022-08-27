package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Program;
import Bean.School;
import DAO.ProgramDAO;
import DAO.SchoolDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddpro")
public class MbAddProgram {

	private Program program;
	private ProgramDAO programDAO;
	private List<School> schoolTable;

	@PostConstruct
	public void init() {
		programDAO = new ProgramDAO();
		program = new Program();
		program.setSchool(new School());

		SchoolDAO dao = new SchoolDAO();
		schoolTable = dao.selectSchools();
		
		System.out.println(schoolTable);

//		schoolTable=programDAO.selectSchools();
	}

	public String save() {
		ProgramDAO programDAO = new ProgramDAO();
		programDAO.insert(program);
		Message.addMessage("INFO", "Adding Program", "Program added successfuly");
		return null;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public ProgramDAO getProgramDAO() {
		return programDAO;
	}

	public void setProgramDAO(ProgramDAO programDAO) {
		this.programDAO = programDAO;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

}
