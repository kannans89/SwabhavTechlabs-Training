
public class StudentCollectionTest {

	public static void main(String[] args) {
		Student s1 = new Student(1, "Manoj");
		Student s2 = new Student(2, "manu");
		Student s3 = new Student(3, "abc");
		Student s4 = new Student(4, "umesh");
		Student[] students = {s1, s2, s3, s4};
		StudentCollection<Student> studentsCollection = new StudentCollection<Student>(Student.noStudents, students);
		
		for(Student student: studentsCollection) {
			System.out.println(student.getName()+"\t"+student.getId());
		}

	}
}
