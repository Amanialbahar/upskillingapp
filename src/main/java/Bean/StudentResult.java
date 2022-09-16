package Bean;

public class StudentResult {

	private Student student;
	private TrainingCourse course;
	private int english_mark;
	private int interview_mark;
	private boolean accepted_flag;
	private String notes;

	public StudentResult() {
	}

	public StudentResult(Student student, TrainingCourse course, int english_mark, int interview_mark,
			boolean accepted_flag, String notes) {

		this.student = student;
		this.course = course;
		this.english_mark = english_mark;
		this.interview_mark = interview_mark;
		this.accepted_flag = accepted_flag;
		this.notes = notes;
	}

	public StudentResult(int english_mark, int interview_mark, boolean accepted_flag, String notes) {

		this.english_mark = english_mark;
		this.interview_mark = interview_mark;
		this.accepted_flag = accepted_flag;
		this.notes = notes;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TrainingCourse getCourse() {
		return course;
	}

	public void setCourse(TrainingCourse course) {
		this.course = course;
	}

	public int getEnglish_mark() {
		return english_mark;
	}

	public void setEnglish_mark(int english_mark) {
		this.english_mark = english_mark;
	}

	public int getInterview_mark() {
		return interview_mark;
	}

	public void setInterview_mark(int interview_mark) {
		this.interview_mark = interview_mark;
	}


	public boolean isAccepted_flag() {
		return accepted_flag;
	}

	public void setAccepted_flag(boolean accepted_flag) {
		this.accepted_flag = accepted_flag;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "StudentResult [student=" + student.getStudent_id() + ", course=" + course.getCourse_id()
				+ ", english_mark=" + english_mark + ", interview_mark=" + interview_mark + ", accepted_flag="
				+ accepted_flag + ", notes=" + notes + "]\n";
	}

}
