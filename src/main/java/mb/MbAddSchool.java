package mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.School;
import DAO.SchoolDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddSchool")
public class MbAddSchool {

	private School school;
	private SchoolDAO schoolDAO;

	@PostConstruct
	public void init() {
		schoolDAO = new SchoolDAO();
		school = new School();
	}

	public String save() {

		SchoolDAO schoolDAO = new SchoolDAO();
		schoolDAO.insert(school);
		Message.addMessage("INFO", "Adding School", "School added successfuly");
		return null;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

}
