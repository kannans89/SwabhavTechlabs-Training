

import java.util.TreeMap;

public class TreeMapPrim {
	public void add(int key, String str, TreeMap<Integer, String> ts) {
		ts.put(key, str);
	}
	
	public void delete(int key,TreeMap<Integer, String> ts) {
		ts.remove(key);
	}
	
	public void search(int key, TreeMap<Integer, String> ts) {
		ts.get(key);
	}
	
	public void update(int key, String str, TreeMap<Integer, String> ts) {
		ts.put(key, str);
	}
}
