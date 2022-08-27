package mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Bean.User;
import DAO.UserDAO;

@ManagedBean(name = "mblogin")
public class MBLogin {

	private User user;
	private UserDAO userdao = null;

	@PostConstruct
	public void init() {
		setUser(new User());
		userdao = new UserDAO();
	}

	public String login() {
		System.out.println("login " + user.getEmail() + " " + user.getPass());
		UserDAO userdao = new UserDAO();
		userdao.selectbyEmail(user.getEmail(), user.getPass());

		if (user != null) {
			return "/secuerd/welcome.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid Login", "Username and password not correct"));
			return null;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
