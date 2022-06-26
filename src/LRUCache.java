import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache {

	public static void main(String[] args) {
		int capacity = 2;
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
			private static final long serialVersionUID = 8066381275105058324L;

			@Override
			protected boolean removeEldestEntry(Entry<String, String> eldest) {
				return size() > capacity;
			}
		};
		map.put("1", "hello");
		map.put("2", "bye");
		System.out.println(map.get("1"));
		map.put("3", "good");
		System.out.println(map);

	}

}
