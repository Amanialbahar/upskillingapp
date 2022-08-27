package Bean;

public class School {

	private int school_id;
	private String school_aname;
	private String school_ename;
	
	public School() {
	}

	public School(int school_id, String school_aname, String school_ename) {
		this.school_id = school_id;
		this.school_aname = school_aname;
		this.school_ename = school_ename;
	}
	
	

	public School(int school_id) {
		this.school_id = school_id;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	public String getSchool_aname() {
		return school_aname;
	}

	public void setSchool_aname(String school_aname) {
		this.school_aname = school_aname;
	}

	public String getSchool_ename() {
		return school_ename;
	}

	public void setSchool_ename(String school_ename) {
		this.school_ename = school_ename;
	}

	@Override
	public String toString() {
		return "School [school_id=" + school_id + ", school_aname=" + school_aname + ", school_ename=" + school_ename
				+ "]";
	}
	
	

}
