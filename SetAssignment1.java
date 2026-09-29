/*
Problem Statement: 
HTech college has organized a cultural festival. Nominations are invited for dance and music. 
Students are allowed to nominate themselves only for one event. Implement findUnique() to fetch unique students 
and findDuplicates() to fetch students who nominated for both events using a HashSet.

Sample Input:
- students = [Student(5004, "Wyatt", "Wyatt@example.com", "Dance"), Student(5010, "Lucy", "Lucy@example.com", "Dance"), ...]

Expected Output:
- findUnique(): Returns set containing unique students based on emailId.
- findDuplicates(): Returns set containing students who applied for both events (Lucy, Aaron).
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Student {
	private int studentId;
	private String studentName;
	private String emailId;
	private String event;

	public Student(int studentId, String studentName, String emailId, String event) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.emailId = emailId;
		this.event = event;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object student) {
		Student otherStudent = (Student) student;
		if (this.emailId.equals(otherStudent.emailId))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return emailId.hashCode();
	}

	@Override
	public String toString() {
		return "Student Id: " + studentId + ", Student Name: " + studentName + ", Email Id: " + emailId;
	}
}

class Tester {

	public static Set<Student> findUnique(List<Student> students) {
		Set<Student> uniqueStudents = new HashSet<>();
		for (Student student : students) {
			uniqueStudents.add(student);
		}
		return uniqueStudents;
	}

	public static Set<Student> findDuplicates(List<Student> students) {
		Set<Student> seenStudents = new HashSet<>();
		Set<Student> duplicateStudents = new HashSet<>();
		for (Student student : students) {
			if (!seenStudents.add(student)) {
				duplicateStudents.add(student);
			}
		}
		return duplicateStudents;
	}
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();

		students.add(new Student(5004, "Wyatt", "Wyatt@example.com","Dance"));
		students.add(new Student(5010, "Lucy", "Lucy@example.com","Dance"));
		students.add(new Student(5550, "Aaron", "Aaron@example.com","Dance"));
		students.add(new Student(5560, "Ruby", "Ruby@example.com","Dance"));
		students.add(new Student(5015, "Sophie", "Sophie@example.com","Music"));
		students.add(new Student(5013, "Clara", "Clara@example.com","Music"));
		students.add(new Student(5010, "Lucy", "Lucy@example.com","Music"));
		students.add(new Student(5011, "Ivan", "Ivan@example.com","Music"));
		students.add(new Student(5550, "Aaron", "Aaron@example.com","Music"));

		Set<Student> studentNominations = findUnique(students);
		System.out.println("Students who have submitted nominations");
		for(Student student: studentNominations)
			System.out.println(student);

		Set<Student> duplicateStudents = findDuplicates(students);
		System.out.println("Students who have submitted nominations for both the events");
		for(Student student: duplicateStudents)
			System.out.println(student);
	}
}
