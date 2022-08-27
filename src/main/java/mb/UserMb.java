package mb;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.swing.text.StyledEditorKit.BoldAction;

import Bean.User;
import DAO.UserDAO;

@ManagedBean(name = "mbuser")
public class UserMb {

	private int user_id;
	private boolean accept;
	private User user;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String signup() {
		UserDAO userdao = new UserDAO();
		userdao.insert(user);
		if (accept == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"TErms & conditions", "Please accept terms and conditions"));
		} else {
			System.out.println(user);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User added successfully"));

		}
		return null;
	}

	public String print() {
		System.out.println(user.toString());
		return null;
	}

	public boolean isaccept() {
		return accept;
	}

	public void setaccept(boolean accept) {
		this.accept = accept;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
