import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetObject {
	public void add(Student student, LinkedHashSet<Student>hs) {
		hs.add(student);
	}
	
	public void delete(Student student, LinkedHashSet<Student>hs) {
		hs.remove(student);
	}
	
	public boolean search(Student student, LinkedHashSet<Student>hs) {
		return hs.contains(student);
	}
	
	public void update(Student student, Student newStudent, LinkedHashSet<Student>hs) {
		for(Student student1: hs) {
			if(student1.equals(student)) {
				hs.remove(student1);
				hs.add(newStudent);
			}
		}
	}
}
