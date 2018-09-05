import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test {
	public static void displayHasSet(HashSet<Student> hs) {
		for(Student s: hs) {
			System.out.println(s.getId()+"\t"+s.getName());
		}
	}

	public static void displayTreeSet(TreeSet<Student> treeset) {
		for(Student s: treeset) {
			System.out.println(s.getId()+"\t"+s.getName());
		}
	}
	
	public static void displayLinkedHashSet(LinkedHashSet<Student> studentsL) {
		for(Student s: studentsL) {
			System.out.println(s.getId()+"\t"+s.getName());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSetObj obj = new HashSetObj();
		HashSet<Student> students = new HashSet<>();
		Student s1 = new Student(101, "Manu");
		Student s2 = new Student(102, "abc");
		Student s3 = new Student(103, "bac");
		
		//hashSetTest(obj, students, s1, s2, s3);
		
		//treesetTest(s1, s2, s3);
		
		//linkedHashSetTest(s1, s2, s3);
	}

	private static void linkedHashSetTest(Student s1, Student s2, Student s3) {
		LinkedHashSet<Student> studentsL = new LinkedHashSet<>();
		LinkedHashSetObject obj3 = new LinkedHashSetObject();
		obj3.add(s1, studentsL);
		obj3.add(s2, studentsL);
		obj3.add(s3, studentsL);
		displayLinkedHashSet(studentsL);
		obj3.delete(s1, studentsL);
		System.out.println(obj3.search(s2, studentsL));
	}

	private static void treesetTest(Student s1, Student s2, Student s3) {
		TreeSetObj obj1 = new TreeSetObj();
		TreeSet<Student> treeset = new TreeSet<>();
		obj1.add(s1, treeset);
		obj1.add(s2, treeset);
		obj1.add(s3, treeset);
		displayTreeSet(treeset);
		obj1.delete(s1, treeset);
		System.out.println(obj1.search(s2, treeset));
	}

	private static void hashSetTest(HashSetObj obj, HashSet<Student> students, Student s1, Student s2, Student s3) {
		obj.add(s1, students);
		obj.add(s2, students);
		obj.add(s3, students);
		//displayHasSet(students);
		obj.delete(s1, students);
		displayHasSet(students);
		System.out.println(obj.search(s2, students));
		//obj.update(s3, s1, students);
		displayHasSet(students);
	}

}
