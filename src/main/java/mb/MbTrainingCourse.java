package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import Bean.TrainingCourse;
import DAO.TrainingCourseDAO;

@ManagedBean(name = "mbTC")
public class MbTrainingCourse {

	private List<TrainingCourse> TCTable;
	private TrainingCourseDAO TCDAO;
	private TrainingCourse selectedTC;
	private boolean propertyName;

	@PostConstruct
	public void init() {
		TCDAO = new TrainingCourseDAO();
		TCTable = TCDAO.selectAll();
		selectedTC = new TrainingCourse();
	}

	public void checkselection() {
		System.out.println("1111");
		System.out.println(getSelectedTC());
	}

	public String updateTC() {
		TCDAO.update(selectedTC);
		TCTable = TCDAO.selectAll();
		return null;
	}

	public String removeTC() {
		TCDAO.delete(selectedTC.getCourse_id());
		TCTable = TCDAO.selectAll();
		return null;
	}

	public List<TrainingCourse> getTCTable() {
		return TCTable;
	}

	public void setTCTable(List<TrainingCourse> tCTable) {
		TCTable = tCTable;
	}

	public TrainingCourseDAO getTCDAO() {
		return TCDAO;
	}

	public void setTCDAO(TrainingCourseDAO tCDAO) {
		TCDAO = tCDAO;
	}

	public TrainingCourse getSelectedTC() {
		return selectedTC;
	}

	public void setSelectedTC(TrainingCourse selectedTC) {
		this.selectedTC = selectedTC;
	}

	public boolean isPropertyName() {
		return propertyName;
	}

	public void setPropertyName(boolean propertyName) {
		this.propertyName = propertyName;
	}

}
