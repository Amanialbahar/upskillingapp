package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.School;
import DAO.SchoolDAO;
@ViewScoped
@ManagedBean(name = "mbSchool")
public class Mbschool {

	private List<School> schoolTable;
	private SchoolDAO schoolDAO;
	private School selectedschool;
	private boolean propertyName;

	@PostConstruct
	public void init() {
		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		selectedschool = new School();
	}

	public void checkselection() {
		System.out.println("selected");
		System.out.println(getSelectedschool());
	}

	public String updateSchool() {
		System.out.println("x");
		schoolDAO.update(selectedschool);
		schoolTable = schoolDAO.selectAll();
		return null;
	}

	public String removeSxhool() {
		schoolDAO.delete(selectedschool.getSchool_id());
		schoolTable = schoolDAO.selectAll();
		return null;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	public School getSelectedschool() {
		return selectedschool;
	}

	public void setSelectedschool(School selectedschool) {
		this.selectedschool = selectedschool;
	}

	public boolean isPropertyName() {
		return propertyName;
	}

	public void setPropertyName(boolean propertyName) {
		this.propertyName = propertyName;
	}

}
