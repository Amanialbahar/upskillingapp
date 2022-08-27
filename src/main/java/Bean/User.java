package Bean;

import java.util.Date;

public class User{

	private String fname;
	private String lname;
	private double expectetSalary;
	private String sex;
	private Date cal;
	private String menu;
	private String email;
	private String mobile;
	private String pass;
	private String cpass;
	private String country;

	

	public User() {
	}



	public User(String fname, String lname, String sex, Date cal, String menu, String email, String pass, String cpass,
			String country) {
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.cal = cal;
		this.menu = menu;
		this.email = email;
		this.pass = pass;
		this.cpass = cpass;
		this.country = country;
	}



	public User(String fname, String lname, String sex, Date cal,String email,String pass ,String country) {
		this.fname = fname;
		this.lname = lname;
		this.sex = sex;
		this.cal = cal;
		this.email = email;
		this.pass=pass;
		this.country = country;
	}



	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getCal() {
		return cal;
	}

	public void setCal(Date cal) {
		this.cal = cal;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", sex=" + sex + ", cal=" + cal + ", menu=" + menu
				+ ", email=" + email + ", pass=" + pass + ", cpass=" + cpass + ", country=" + country + "]+\n ";
	}



	public double getExpectetSalary() {
		return expectetSalary;
	}



	public void setExpectetSalary(double expectetSalary) {
		this.expectetSalary = expectetSalary;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	
	
	

}
