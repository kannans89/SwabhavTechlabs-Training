import java.util.LinkedHashMap;

public class LinkedHashMapObj {
	public void add(Student s, int key,  LinkedHashMap<Integer, Student> hashmap) {
		hashmap.put(key, s);
	}
	
	public void delete(int key, LinkedHashMap<Integer, Student> hashmap) {
		hashmap.remove(key);
	}
	
	public boolean search(int key,  LinkedHashMap<Integer, Student> hashmap) {
		return hashmap.containsKey(key);
	}
	
	public void update(Student updated, int key,  LinkedHashMap<Integer, Student> hashmap) {
		hashmap.put(key, updated);
	}
}
