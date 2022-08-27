
package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Program;
import Bean.School;
import Bean.Student;
import Bean.University;
import DAO.ProgramDAO;
import DAO.SchoolDAO;
import DAO.StudentDAO;
import DAO.UniversityDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddStu")
public class MbAddStudent {

	private Student student;
	private List<University> uniTable;
	// private List<Program> progTable;
	private Program progTable;
	private List<School> schoolTable;
	private StudentDAO stuDao;

	@PostConstruct
	private void init() {
		stuDao = new StudentDAO();

		UniversityDAO uni = new UniversityDAO();
		uniTable = uni.selectAll();

//		ProgramDAO prog = new ProgramDAO();
//		progTable = prog.selectall();

		ProgramDAO dao = new ProgramDAO();
		progTable = dao.selectbyIdp(student.getProgram().getSchool().getSchool_id());
		System.out.println(progTable);

		SchoolDAO sdao = new SchoolDAO();
		schoolTable = sdao.selectAll();

	}

//	public void getProgBySchool() {
//		ProgramDAO dao = new ProgramDAO();
//		progTable = dao.selectbyIdp(student.getProgram().getSchool().getSchool_id());
//		System.out.println(progTable);
//	}

	public String save() {
		stuDao.insert(student);
		Message.addMessage("INFO", "Adding Student", "Student added successfuly");
		student = new Student();
		student.setUniversity(new University());
		student.setProgram(new Program());
		student.setSchool(new School());

		return null;
	}

	public Student getStudent() {
		if (student == null) {
			student = new Student();
			student.setUniversity(new University());
			student.setProgram(new Program());
			student.setSchool(new School());
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<University> getUniTable() {
		return uniTable;
	}

	public void setUniTable(List<University> uniTable) {
		this.uniTable = uniTable;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public Program getProgTable() {
		return progTable;
	}

	public void setProgTable(Program progTable) {
		this.progTable = progTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public StudentDAO getStuDao() {
		return stuDao;
	}

	public void setStuDao(StudentDAO stuDao) {
		this.stuDao = stuDao;
	}

}
