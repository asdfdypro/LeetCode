package asdf.test3;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * (LRU Cache) Design and implement a data structure for Least Recently Used
 * (LRU) cache. It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * 
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * 元素计数，没有访问的增加1
 * 
 * 超时
 */
public class LRUCache {
	private final int MAX_CAPACITY;

	private Map<Integer, Item> map;

	public LRUCache(int capacity) {
		this.MAX_CAPACITY = capacity;
		map = new HashMap<Integer, Item>(capacity);

	}

	// 不存在的元素
	public int get(int key) {
		Item item = map.get(key);
		if (item == null) {
			return -1;
		}
		visit(item);
		return item.value;
	}

	// 更新元素
	public void set(int key, int value) {
		Item item;
		item = map.get(key);
		if (item != null) {
			item.value = value;
			visit(item);
		} else {
			item = new Item(key, value);
			map.put(key, item);
			visit(item);
			while (map.size() > MAX_CAPACITY) {
				for (Item i : map.values()) {
					if (i.count > item.count) {
						item = i;
					}
				}
				map.remove(item.key);
			}
		}
	}

	private void visit(Item item) {
		for (Item i : map.values()) {
			i.count++;
		}
		item.count = 0;
	}

	class Item {
		int key;
		int value;
		int count;

		public Item(int key, int value) {
			super();
			this.key = key;
			this.value = value;
			this.count = 0;
		}

	}
	
	public static void main(String[] args) {
		LRUCache lru=new LRUCache(1);
		lru.set(2, 1);
		System.out.println(lru.get(2));
		lru.set(3, 2);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
	}
}