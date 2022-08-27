package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.University;
import DAO.UniversityDAO;

@ViewScoped
@ManagedBean(name = "mbUniversity")
public class MbUniversity {

	private List<University> universityTable;
	private UniversityDAO universityDAO;
	private University selectedUniversity;
	private boolean propertyName;

	@PostConstruct
	public void init() {
		universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		selectedUniversity = new University();
	}

	public void checkselection() {
		System.out.println("1111");
		System.out.println(getSelectedUniversity());
	}

	public String updateUniversity() {
		System.out.println("x");
		universityDAO.update(selectedUniversity);
		universityTable = universityDAO.selectAll();
		return null;
	}

	public String removeUniversity() {
		universityDAO.delete(selectedUniversity.getUniversity_id());
		universityTable = universityDAO.selectAll();
		return null;
	}

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}

	public UniversityDAO getUniversityDAO() {
		return universityDAO;
	}

	public void setUniversityDAO(UniversityDAO universityDAO) {
		this.universityDAO = universityDAO;
	}

	public University getSelectedUniversity() {
		return selectedUniversity;
	}

	public void setSelectedUniversity(University selectedUniversity) {
		this.selectedUniversity = selectedUniversity;
	}

	public boolean isPropertyName() {
		return propertyName;
	}

	public void setPropertyName(boolean propertyName) {
		this.propertyName = propertyName;
	}

}
