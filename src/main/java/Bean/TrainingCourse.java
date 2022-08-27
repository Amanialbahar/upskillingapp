package Bean;

public class TrainingCourse {

	private int course_id;
	private String course_aname;
	private String course_ename;
	private int max_stu;
	private String short_desc;
	private String detailed_desc;

	public TrainingCourse() {
	}

	public TrainingCourse(int course_id, String course_aname, String course_ename, int max_stu, String short_desc,
			String detailed_desc) {
		this.course_id = course_id;
		this.course_aname = course_aname;
		this.course_ename = course_ename;
		this.max_stu = max_stu;
		this.short_desc = short_desc;
		this.detailed_desc = detailed_desc;
	}

	
	
	public TrainingCourse(int course_id, String course_aname, String course_ename, String short_desc,
			String detailed_desc) {
		this.course_id = course_id;
		this.course_aname = course_aname;
		this.course_ename = course_ename;
		this.short_desc = short_desc;
		this.detailed_desc = detailed_desc;
	}

	public TrainingCourse(int course_id) {
		this.course_id = course_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_aname() {
		return course_aname;
	}

	public void setCourse_aname(String course_aname) {
		this.course_aname = course_aname;
	}

	public String getCourse_ename() {
		return course_ename;
	}

	public void setCourse_ename(String course_ename) {
		this.course_ename = course_ename;
	}

	public int getMax_stu() {
		return max_stu;
	}

	public void setMax_stu(int max_stu) {
		this.max_stu = max_stu;
	}

	public String getShort_desc() {
		return short_desc;
	}

	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}

	public String getDetailed_desc() {
		return detailed_desc;
	}

	public void setDetailed_desc(String detailed_desc) {
		this.detailed_desc = detailed_desc;
	}

	@Override
	public String toString() {
		return  course_id +"  " + course_aname + "  "
				+ course_ename + "  max_stu=" + max_stu + "  " + short_desc + "  "
				+ detailed_desc + "\n";
	}


}
