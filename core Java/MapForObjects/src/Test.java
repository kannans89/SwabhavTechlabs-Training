import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
	public static void displayHashMap(HashMap<Integer, Student> hm) {
		Set<Map.Entry<Integer,Student>> set = hm.entrySet();
		// Display the set.
		for(Map.Entry<Integer, Student> me : set) {
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue().getId());
		System.out.println(me.getValue().getName());
		}
	}
	
	public static void displayTreeMap(TreeMap<Integer, Student> tm) {
		Set<Map.Entry<Integer,Student>> set = tm.entrySet();
		// Display the set.
		for(Map.Entry<Integer, Student> me : set) {
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue().getId());
		System.out.println(me.getValue().getName());
		}
	}
	
	public static void displayLinkedHashMap(LinkedHashMap<Integer, Student> tm) {
		Set<Map.Entry<Integer,Student>> set = tm.entrySet();
		// Display the set.
		for(Map.Entry<Integer, Student> me : set) {
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue().getId());
		System.out.println(me.getValue().getName());
		}
	}
	public static void main(String[] args) {
		Student s1 = new Student(101, "Manoj");
		Student s2 = new Student(102, "manu");
		Student s3 = new Student(103, "abc");
		
		hashmapTest();
		
		//treemaptest(s1, s2, s3);
		
		//linkedHashMapTest(s1, s2, s3);
	}

	private static void linkedHashMapTest(Student s1, Student s2, Student s3) {
		LinkedHashMapObj linkedhashmap = new LinkedHashMapObj();
		LinkedHashMap<Integer, Student> lhm = new LinkedHashMap<>();
		linkedhashmap.add(s1, 1, lhm);
		linkedhashmap.add(s2, 2, lhm);
		linkedhashmap.add(s3, 3, lhm);
		displayLinkedHashMap(lhm);
		linkedhashmap.delete(1, lhm);
		System.out.println(linkedhashmap.search(3, lhm));
	}

	private static void treemaptest(Student s1, Student s2, Student s3) {
		TreeMapObj tm = new TreeMapObj();
		TreeMap<Integer, Student> treemap = new TreeMap<>();
		tm.add(s1, 1, treemap);
		tm.add(s2, 2, treemap);
		tm.add(s3, 3, treemap);
		displayTreeMap(treemap);
		tm.delete(1, treemap);
		System.out.println(tm.search(2, treemap));
	}
	private static void hashmapTest() {
		HashMapObj hmp = new HashMapObj();
		HashMap<Integer, Student> hashmap = new HashMap<>();
		Student s1 = new Student(101, "Manoj");
		Student s2 = new Student(102, "manu");
		Student s3 = new Student(103, "abc");
		hmp.add(s1, 1, hashmap);
		hmp.add(s2, 2, hashmap);
		hmp.add(s3, 3, hashmap);
		displayHashMap(hashmap);
		hmp.delete(1, hashmap);
		System.out.println(hmp.search(1, hashmap));
		
		
	}
}
