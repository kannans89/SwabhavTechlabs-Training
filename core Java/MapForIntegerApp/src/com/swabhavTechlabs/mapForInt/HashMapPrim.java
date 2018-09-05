

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapPrim {
	
	public void add(int key, String str, HashMap<Integer, String> hm) {
		hm.put(key, str);
	}
	
	public void delete(int key, HashMap<Integer, String> hm) {
		hm.remove(key);
	}
	
	public void update(int key, String updatedValue, HashMap<Integer, String> hm) {
		hm.put(key, updatedValue);
	}
	
	public boolean search(int key, HashMap<Integer, String> hm) {
		return hm.containsKey(key);
	}
}