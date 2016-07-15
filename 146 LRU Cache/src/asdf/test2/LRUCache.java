package asdf.test2;

import java.util.LinkedHashMap;

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
 * 使用队列组织数据，访问的数据放到队首，替换的元素从尾部删除
 */
// 继承LinkedHashMap
public class LRUCache extends LinkedHashMap<Integer, Integer> {
	private final int MAX_CAPACITY;

	public LRUCache(int capacity) {
		super((int) Math.ceil(capacity / 0.75) + 1, 0.75f, true);
		this.MAX_CAPACITY = capacity;
	}

	public int get(int key) {
		Integer value=super.get(key);
		if (value==null) {
			return -1;
		}else
		return value;
	}

	public void set(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {

		return size() > MAX_CAPACITY;
	}

}