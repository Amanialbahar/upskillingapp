package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Student;
import Bean.StudentTrainingCourse;
import Bean.TrainingCourse;
import DAO.StudentDAO;
import DAO.StudentTrainingCourseDAO;
import DAO.TrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddStuCo")
public class MbAddStuCourse {

	private List<StudentTrainingCourse> stuTCTable;
	private StudentTrainingCourseDAO dao;
	private StudentTrainingCourse stuCourse;
	private List<Student> stuTable;
	private List<TrainingCourse> courseTable;

	@PostConstruct
	private void init() {
		StudentDAO stuDAO = new StudentDAO();
		stuTable = stuDAO.selectall();

		TrainingCourseDAO courseDao = new TrainingCourseDAO();
		courseTable = courseDao.selectAll();
		
		dao = new StudentTrainingCourseDAO();
		stuTCTable = dao.selectall();
		stuCourse = new StudentTrainingCourse();
		stuCourse.setStudent(new Student());
		stuCourse.setCourse(new TrainingCourse());

	
	}

	public String save() {
		StudentDAO stuDAO = new StudentDAO();
		stuTable = stuDAO.selectall();
		System.out.println(stuTable);

		TrainingCourseDAO courseDao = new TrainingCourseDAO();
		courseTable = courseDao.selectAll();
		System.out.println(courseTable);

		dao.insert(stuCourse);
		Message.addMessage("INFO", "Adding Trainig Course For Student", " Student Training Course added");

		stuCourse = new StudentTrainingCourse();
		stuCourse.setStudent(new Student());
		stuCourse.setCourse(new TrainingCourse());

		return null;
	}

	public StudentTrainingCourse getStuCourse() {
		if (stuCourse == null) {
			stuCourse = new StudentTrainingCourse();
			stuCourse.setStudent(new Student());
			stuCourse.setCourse(new TrainingCourse());
		}
		return stuCourse;
	}

	public void setStuCourse(StudentTrainingCourse stuCourse) {
		this.stuCourse = stuCourse;
	}

	public List<Student> getStuTable() {
		return stuTable;
	}

	public void setStu(List<Student> stuTable) {
		this.stuTable = stuTable;
	}

	public List<TrainingCourse> getCourseTable() {
		return courseTable;
	}

	public void setCourse(List<TrainingCourse> courseTable) {
		this.courseTable = courseTable;
	}

	public StudentTrainingCourseDAO getDao() {
		return dao;
	}

	public void setDao(StudentTrainingCourseDAO dao) {
		this.dao = dao;
	}

	public List<StudentTrainingCourse> getStuTCTable() {
		return stuTCTable;
	}

	public void setStuTCTable(List<StudentTrainingCourse> stuTCTable) {
		this.stuTCTable = stuTCTable;
	}

}
