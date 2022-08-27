package mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.TrainingCourse;
import DAO.TrainingCourseDAO;
import util.Message;
@ViewScoped
@ManagedBean(name = "mbAddTC")
public class MbAddCourse {

	private TrainingCourse selectedTC;

	public String save() {
		TrainingCourseDAO dao = new TrainingCourseDAO();
		dao.insert(selectedTC);
		Message.addMessage("INFO", "Adding Course", "Training Course added successfuly");
		selectedTC = new TrainingCourse();
		return null;
	}

	public TrainingCourse getSelectedTC() {
		if (selectedTC == null) {
			selectedTC = new TrainingCourse();
		}
		return selectedTC;
	}

	public void setSelectedTC(TrainingCourse selectedTC) {
		this.selectedTC = selectedTC;
	}

}
