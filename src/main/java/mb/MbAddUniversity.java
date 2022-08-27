package mb;

import javax.faces.bean.ManagedBean;

import Bean.University;
import DAO.UniversityDAO;
import util.Message;

@ManagedBean(name = "mbAddUniversity")
public class MbAddUniversity {

	private University university;

	public String save() {
		UniversityDAO uniDao = new UniversityDAO();
		uniDao.insert(university);
		Message.addMessage("INFO", "Adding University", "University added successfuly");

		university = new University();
		return null;
	}

	public University getUniversity() {
		if (university == null) {
			university = new University();
		}
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}
