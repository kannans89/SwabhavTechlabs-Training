import java.util.HashSet;

public class HashSetObj {
	public void HashSetobj() {
		// Create a hash set.
		HashSet<Student> hs = new HashSet<Student>();
		// Add elements to the hash set.
		hs.add(new Student(101, "abc"));
		hs.add(new Student(101, "abc"));
		hs.add(new Student(101, "abc"));
		hs.add(new Student(101, "abc"));
		hs.add(new Student(101, "abc"));
		hs.add(new Student(101, "abc"));
		System.out.println(hs.toString());
		}
}
