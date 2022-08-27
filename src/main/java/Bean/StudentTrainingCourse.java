package Bean;

public class StudentTrainingCourse {

	private Student student;
	private TrainingCourse course;
	private int priority;

	public StudentTrainingCourse() {
	}

	public StudentTrainingCourse(Student student, TrainingCourse course, int priority) {
		this.student = student;
		this.course = course;
		this.priority = priority;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "StudentTrainingCourse [student=" + student.getStudent_id() + ", course" + course.getCourse_id() + ", priority=" + priority + "]+\n";
	}

}
