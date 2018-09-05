import java.util.HashMap;

public class HashMapObj {
	public void add(Student s, int key,  HashMap<Integer, Student> hashmap) {
		hashmap.put(key, s);
	}
	
	public void delete(int key, HashMap<Integer, Student> hashmap) {
		hashmap.remove(key);
	}
	
	public boolean search(int key,  HashMap<Integer, Student> hashmap) {
		return hashmap.containsKey(key);
	}
	
	public void update(Student updated, int key,  HashMap<Integer, Student> hashmap) {
		hashmap.put(key, updated);
	}
}
