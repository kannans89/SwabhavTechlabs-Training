import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetObj {
	public void add(Student student, TreeSet<Student>hs) {
		hs.add(student);
	}
	
	public void delete(Student student, TreeSet<Student>hs) {
		hs.remove(student);
	}
	
	public boolean search(Student student, TreeSet<Student>hs) {
		return hs.contains(student);
	}
	
	public void update(Student student, Student newStudent, TreeSet<Student>hs) {
		for(Student student1: hs) {
			if(student1.equals(student)) {
				hs.remove(student1);
				hs.add(newStudent);
			}
		}
	}
}
