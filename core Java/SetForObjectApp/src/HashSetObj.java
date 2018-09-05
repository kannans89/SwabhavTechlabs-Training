import java.util.HashSet;

public class HashSetObj {
	public void add(Student student, HashSet<Student>hs) {
		hs.add(student);
	}
	
	public void delete(Student student, HashSet<Student>hs) {
		hs.remove(student);
	}
	
	public boolean search(Student student, HashSet<Student>hs) {
		return hs.contains(student);
	}
	
	public void update(Student student, Student newStudent, HashSet<Student>hs) {
		for(Student student1: hs) {
			if(student1.equals(student)) {
				hs.remove(student1);
				hs.add(newStudent);
			}
		}
	}
}
