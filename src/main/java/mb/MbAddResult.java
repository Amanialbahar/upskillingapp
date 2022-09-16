package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Student;
import Bean.StudentResult;
import Bean.TrainingCourse;
import DAO.StudentDAO;
import DAO.StudentResultDAO;
import DAO.TrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddResult")
public class MbAddResult {

	private StudentResult stuResult;
	private StudentResultDAO dao;
	private List<Student> stutable;
	private List<TrainingCourse> stuTCtable;

	@PostConstruct
	private void init() {
		StudentDAO stuDao = new StudentDAO();
		stutable = stuDao.selectall();

		TrainingCourseDAO tcDao = new TrainingCourseDAO();
		stuTCtable = tcDao.selectAll();

		stuResult = new StudentResult();
		dao = new StudentResultDAO();
		stuResult.setStudent(new Student());
		stuResult.setCourse(new TrainingCourse());
	}

	public String save() {
		dao = new StudentResultDAO();
		StudentDAO stuDAO = new StudentDAO();
		stutable = stuDAO.selectall();
		// System.out.println(stutable);

		TrainingCourseDAO courseDao = new TrainingCourseDAO();
		stuTCtable = courseDao.selectAll();
		// System.out.println(stuTCtable);

		dao.insert(stuResult);
		Message.addMessage("INFO", "Adding Student Result", "Student Result added successfuly");

		stuResult = new StudentResult();
		stuResult.setStudent(new Student());
		stuResult.setCourse(new TrainingCourse());
		return null;
	}

	public StudentResult getStuResult() {
		if (stuResult == null) {
			stuResult = new StudentResult();

		}
		return stuResult;
	}

	public void setStuResult(StudentResult stuResult) {
		this.stuResult = stuResult;
	}

	public StudentResultDAO getDao() {
		return dao;
	}

	public void setDao(StudentResultDAO dao) {
		this.dao = dao;
	}

	public List<Student> getStutable() {
		return stutable;
	}

	public void setStutable(List<Student> stutable) {
		this.stutable = stutable;
	}

	public List<TrainingCourse> getStuTCtable() {
		return stuTCtable;
	}

	public void setStuTCtable(List<TrainingCourse> stuTCtable) {
		this.stuTCtable = stuTCtable;
	}

}
