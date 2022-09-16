package mb;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import Bean.University;
import DAO.UniversityDAO;
import report.Reports;

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

	public void redirect() throws IOException {
		System.out.println(selectedUniversity.getWebsite());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect(selectedUniversity.getWebsite());
	}

	public String runUniReport() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/ictlogo.png"));
		param.put("P_image", image);
		Reports report = new Reports();
		report.runPdf("university.jasper", null);
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
