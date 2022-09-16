
package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

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
	private List<School> schoolTable;
	private List<Program> progTable;
	private StudentDAO stuDao;

	@PostConstruct
	private void init() {
		stuDao = new StudentDAO();

		UniversityDAO uni = new UniversityDAO();
		uniTable = uni.selectAll();

		SchoolDAO sdao = new SchoolDAO();
		schoolTable = sdao.selectAll();
	}

	public void getProgBySchool(final AjaxBehaviorEvent event) {
		System.out.println("School");
		System.out.println(student.getSchool().getSchool_id());
		ProgramDAO dao = new ProgramDAO();
		setProgTable(dao.getProgBySchool(student.getSchool().getSchool_id()));
		System.out.println(getProgTable());
	}

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

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public StudentDAO getStuDao() {
		return stuDao;
	}

	public void setStuDao(StudentDAO stuDao) {
		this.stuDao = stuDao;
	}

	public List<Program> getProgTable() {
		return progTable;
	}

	public void setProgTable(List<Program> progTable) {
		this.progTable = progTable;
	}

}
