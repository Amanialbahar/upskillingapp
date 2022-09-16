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

@ViewScoped
@ManagedBean(name = "mbStu")
public class MbStudent {

	private List<Student> stuTable;
	private StudentDAO stuDAO;
	private Student selectedStu;
	private boolean propertyName;
	private List<University> uniTable;
	private List<Program> progTable;
	private List<School> schoolTable;

	@PostConstruct
	public void init() {
		stuDAO = new StudentDAO();
		stuTable = stuDAO.selectall();
		
		selectedStu = new Student();
		selectedStu.setUniversity(new University());
		selectedStu.setSchool(new School());
		selectedStu.setProgram(new Program());
		
		UniversityDAO uni = new UniversityDAO();
		uniTable = uni.selectAll();

		ProgramDAO prog = new ProgramDAO();
		progTable = prog.selectall();

		SchoolDAO sdao = new SchoolDAO();
		schoolTable = sdao.selectAll();
	}

	public void checkselection() {
		System.out.println("1111");
		System.out.println(getSelectedStu());
	}

	public String updateStudent() {
		stuDAO.update(selectedStu);
		stuTable = stuDAO.selectall();
		return null;
	}

	public String removeStudent() {
		stuDAO.delete(selectedStu.getStudent_id());
		stuTable = stuDAO.selectall();
		return null;
	}

	public List<Student> getStuTable() {
		return stuTable;
	}

	public void setStuTable(List<Student> stuTable) {
		this.stuTable = stuTable;
	}

	public StudentDAO getStuDAO() {
		return stuDAO;
	}

	public void setStuDAO(StudentDAO stuDAO) {
		this.stuDAO = stuDAO;
	}

	public Student getSelectedStu() {
		return selectedStu;
	}

	public void setSelectedStu(Student selectedStu) {
		this.selectedStu = selectedStu;
	}

	public boolean isPropertyName() {
		return propertyName;
	}

	public void setPropertyName(boolean propertyName) {
		this.propertyName = propertyName;
	}

	public List<University> getUniTable() {
		return uniTable;
	}

	public void setUniTable(List<University> uniTable) {
		this.uniTable = uniTable;
	}

	public List<Program> getProgTable() {
		return progTable;
	}

	public void setProgTable(List<Program> progTable) {
		this.progTable = progTable;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	
	
}
