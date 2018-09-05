

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
	
	public static void displayTreeMap(HashMap<Integer, String> hm) {
		Set<Map.Entry<Integer,String>> set = hm.entrySet();
		// Display the set.
		for(Map.Entry<Integer, String> me : set) {
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue());
		}
	}
	
	public static void displaylinkedHasMap(LinkedHashMap<Integer, String> lm) {
		Set<Map.Entry<Integer,String>> set = lm.entrySet();
		// Display the set.
		for(Map.Entry<Integer, String> me : set) {
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue());
		}
	}
	
	public static void displayTreeMap(TreeMap<Integer, String> tm) {
		Set<Map.Entry<Integer,String>> set = tm.entrySet();
		// Display the set.
		for(Map.Entry<Integer, String> me : set) {
		System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue());
		}
	}
	public static void main(String[] args) {
		HashMapPrim hmp = new HashMapPrim();
		HashMap<Integer, String> hm = new HashMap<>();
		hmp.add(1, "manoj", hm);
		hmp.add(2, "manu", hm);
		//displayTreeMap(hm);
		hmp.delete(1, hm);
		hmp.add(1, "hi", hm);
		hmp.search(2, hm);
		hmp.update(2, "hello", hm);
		//displayTreeMap(hm);
		
		LinkedHashMapPrim lmp = new LinkedHashMapPrim();
		LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
		lmp.add(1, "abc", lm);
		lmp.add(2, "bac", lm);
		displaylinkedHasMap(lm);
		lmp.delete(1, lm);
		System.out.println(lmp.search(2, lm));
		lmp.update(1, "fbdsjb", lm);
		displaylinkedHasMap(lm);
		
		TreeMapPrim tmp = new TreeMapPrim();
		TreeMap<Integer, String> tm = new TreeMap<>();
		tmp.add(1, "asd", tm);
		tmp.add(2, "zxc", tm);
		displayTreeMap(tm);
		tmp.delete(1, tm);
		tmp.add(5, "qwe", tm);
		tmp.search(5, tm);
		tmp.update(5, "vfewuifhuiehcbu", tm);
		displayTreeMap(tm);
	}
}
