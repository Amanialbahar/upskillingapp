package Bean;

import java.util.Date;

public class Student {

	private int student_id;
	private String student_aname;
	private String student_ename;
	private Date birthdate;
	private int sex;
	private String mobile;
	private String email;
	private University university;
	private School school;
	private Program program;
	private int final_avarage;
	private int max_avarage;
	private String rate;
	private int graduate_year;
	private int sem;

	public Student() {
	}

	public Student(int student_id, String student_aname, String student_ename, Date birthdate, int sex, String mobile,
			String email, int final_avarage, int max_avarage, String rate, int graduate_year, int sem) {
		this.student_id = student_id;
		this.student_aname = student_aname;
		this.student_ename = student_ename;
		this.birthdate = birthdate;
		this.sex = sex;
		this.mobile = mobile;
		this.email = email;
		this.final_avarage = final_avarage;
		this.max_avarage = max_avarage;
		this.rate = rate;
		this.graduate_year = graduate_year;
		this.sem = sem;
	}

	public Student(int student_id, String student_aname, String student_ename, Date birthdate, int sex, String mobile,
			String email, University university, School school, Program program, int final_avarage, int max_avarage,
			String rate, int graduate_year, int sem) {
		this.student_id = student_id;
		this.student_aname = student_aname;
		this.student_ename = student_ename;
		this.birthdate = birthdate;
		this.sex = sex;
		this.mobile = mobile;
		this.email = email;
		this.university = university;
		this.school = school;
		this.program = program;
		this.final_avarage = final_avarage;
		this.max_avarage = max_avarage;
		this.rate = rate;
		this.graduate_year = graduate_year;
		this.sem = sem;
	}

	public Student(int student_id) {
		this.student_id = student_id;
	}

	public Student(int student_id, String student_aname, String student_ename, int sex, String mobile, String email,
			int final_avarage, int max_avarage, String rate, int graduate_year, int sem) {
		this.student_id = student_id;
		this.student_aname = student_aname;
		this.student_ename = student_ename;
		this.sex = sex;
		this.mobile = mobile;
		this.email = email;
		this.final_avarage = final_avarage;
		this.max_avarage = max_avarage;
		this.rate = rate;
		this.graduate_year = graduate_year;
		this.sem = sem;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_aname() {
		return student_aname;
	}

	public void setStudent_aname(String student_aname) {
		this.student_aname = student_aname;
	}

	public String getStudent_ename() {
		return student_ename;
	}

	public void setStudent_ename(String student_ename) {
		this.student_ename = student_ename;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public int getFinal_avarage() {
		return final_avarage;
	}

	public void setFinal_avarage(int final_avarage) {
		this.final_avarage = final_avarage;
	}

	public int getMax_avarage() {
		return max_avarage;
	}

	public void setMax_avarage(int max_avarage) {
		this.max_avarage = max_avarage;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getGraduate_year() {
		return graduate_year;
	}

	public void setGraduate_year(int graduate_year) {
		this.graduate_year = graduate_year;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_aname=" + student_aname + ", student_ename="
				+ student_ename + ", birthdate=" + birthdate + ", sex=" + sex + ", mobile=" + mobile + ", email="
				+ email + ", university=" + university + ", school=" + school + " program=" + program
				+ ", final_avarage=" + final_avarage + ", max_avarage=" + max_avarage + ", rate=" + rate
				+ ", graduate_year=" + graduate_year + ", sem=" + sem + "]+\n";
	}

}
