import javax.persistence.OneToOne;

@Entity
public class Attendance {
	
	/*
	 * Attendance : -student : Student -date : LocalDate -isPresent : boolean
	 */
	
	@OneToOne
	private Student student;
	private LocalDate date;
	private boolean isPresent;


	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Attendance(Student student, LocalDate date, boolean isPresent) {
		super();
		this.student = student;
		this.date = date;
		this.isPresent = isPresent;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isPresent() {
		return isPresent;
	}
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	@Override
	public String toString() {
		return "Attendance [date=" + date + ", isPresent=" + isPresent + "]";
	}
	
	
}
