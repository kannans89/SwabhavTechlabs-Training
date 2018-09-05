import java.util.TreeMap;

public class TreeMapObj {
	public void add(Student s, int key,  TreeMap<Integer, Student> hashmap) {
		hashmap.put(key, s);
	}
	
	public void delete(int key, TreeMap<Integer, Student> hashmap) {
		hashmap.remove(key);
	}
	
	public boolean search(int key,  TreeMap<Integer, Student> hashmap) {
		return hashmap.containsKey(key);
	}
	
	public void update(Student updated, int key,  TreeMap<Integer, Student> hashmap) {
		hashmap.put(key, updated);
	}
}
