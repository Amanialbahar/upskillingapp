package mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import util.Message;

@ManagedBean(name = "mbSec") 
@SessionScoped
public class MBSecurity {

	private String username;
	private String password;
	private boolean logon;

	public String checkUser() {
		if (username.equalsIgnoreCase("java") && password.equals("123")) {
			logon = true;
			return "/home.xhtml";
		} else {
			logon = false;
			Message.addMessage("Error", " ", "Please check username or password");
			return null;
		}
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/home.xhtml?faces-redirect=true";
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogon() {
		return logon;
	}

	public void setLogon(boolean logon) {
		this.logon = logon;
	}

}
