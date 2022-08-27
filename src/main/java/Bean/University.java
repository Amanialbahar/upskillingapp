package Bean;

public class University {

	private int university_id;
	private String university_aname;
	private String university_ename;
	private String website;

	public University() {
	}

	public University(int university_id, String university_aname, String university_ename, String website) {
		this.university_id = university_id;
		this.university_aname = university_aname;
		this.university_ename = university_ename;
		this.website = website;
	}

	public University(int university_id) {
		this.university_id = university_id;
	}

	public int getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}

	public String getUniversity_aname() {
		return university_aname;
	}

	public void setUniversity_aname(String university_aname) {
		this.university_aname = university_aname;
	}

	public String getUniversity_ename() {
		return university_ename;
	}

	public void setUniversity_ename(String university_ename) {
		this.university_ename = university_ename;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "University [university_id=" + university_id + ", university_aname=" + university_aname
				+ ", university_ename=" + university_ename + ", website=" + website + "]+\n";
	}



}
