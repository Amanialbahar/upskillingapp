package Bean;

public class Program {

	private School school;
	private int program_id;
	private String program_aname;
	private String program_ename;

	public Program() {
	}

	public Program(School school, int program_id, String program_aname, String program_ename) {
		this.setSchool(school);
		this.program_id = program_id;
		this.program_aname = program_aname;
		this.program_ename = program_ename;
	}

	
	
	public Program(int program_id, String program_aname, String program_ename) {
		this.program_id = program_id;
		this.program_aname = program_aname;
		this.program_ename = program_ename;
	}
	
	

	public Program(int program_id) {
		this.program_id = program_id;
	}

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}


	public String getProgram_aname() {
		return program_aname;
	}

	public void setProgram_aname(String program_aname) {
		this.program_aname = program_aname;
	}

	public String getProgram_ename() {
		return program_ename;
	}

	public void setProgram_ename(String program_ename) {
		this.program_ename = program_ename;
	}

	@Override
	public String toString() {
		return "Program [program_id=" + program_id + ", school_id=" + school.getSchool_id() + ", program_aname=" + program_aname
				+ ", program_ename=" + program_ename + "]+\n";
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
