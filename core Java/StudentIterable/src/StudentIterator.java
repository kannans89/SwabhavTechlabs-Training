import java.util.Iterator;

public class StudentIterator<Student> implements Iterator<Student> {
	private int counter;
	Student[] students;

	public StudentIterator(int counter, Student[] s) {
		this.counter = counter;
		this.students = s;
	}

	@Override
	public boolean hasNext() {
		return counter > 0;
	}

	@Override
	public Student next() {
		if (counter > 0) {
			return students[--counter];
		}
		return null;
	}

}
