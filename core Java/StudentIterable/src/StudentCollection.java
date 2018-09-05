import java.util.Iterator;

public class StudentCollection<Student> implements Iterable<Student>{
	private int counter;
	Student[] students;
	StudentCollection(int count, Student[] s){
		this.counter = count;
		this.students = s;
	}
	
	@Override
	public Iterator<Student> iterator() {
		return new StudentIterator<Student>(counter, students);
	}
	
}
