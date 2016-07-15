package asdf.test1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import asdf.test1.LRUCache;

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
 * 使用队列组织数据，访问的数据放到队首，替换的元素从尾部删除 使用LinkedList超时，其中的remove操作会遍历序列，需要手动实现
 */
public class LRUCache {
	private final int MAX_CAPACITY;

	private Map<Integer, Item> map;
	private Item head, end;

	public LRUCache(int capacity) {
		this.MAX_CAPACITY = capacity;
		map = new HashMap<Integer, Item>(capacity);
		head = null;
		end = null;
	}

	// 不存在的元素
	public int get(int key) {
		Item item = map.get(key);
		if (item == null) {
			return -1;
		}
		moveToFirst(item);
		return item.value;
	}

	// 更新元素
	public void set(int key, int value) {
		Item item;
		item = map.get(key);
		if (item != null) {
			item.value = value;
			moveToFirst(item);
		} else {
			item = new Item(key, value);
			map.put(key, item);
			addFirst(item);
			while (map.size() > MAX_CAPACITY) {
				item = removeLast();
				if (item != null) {
					map.remove(item.key);
				}
			}
		}
	}

	private void moveToFirst(Item item) {
		if (item.pre == null)
			return;
		item.pre.next = item.next;
		if (item.next == null)
			end = item.pre;
		else
			item.next.pre = item.pre;
		addFirst(item);
	}

	private void addFirst(Item item) {
		if (head == null) {
			head = item;
			end = item;
		} else {
			item.next = head;
			item.pre = null;
			head.pre = item;
			head = item;
		}
	}

	private Item removeLast() {
		if (end != null) {
			Item item = end;
			end = end.pre;
			if (end != null)
				end.next = null;
			else {
				end = null;
				head = null;
			}
			return item;
		}
		return null;
	}

	class Item {
		int key;
		int value;
		Item pre, next;

		public Item(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(1);
		lru.set(2, 1);
		System.out.println(lru.get(2));
		lru.set(3, 2);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
	}
}