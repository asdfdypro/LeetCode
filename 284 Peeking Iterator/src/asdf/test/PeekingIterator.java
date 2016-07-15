package asdf.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

	/**
	 * (带peek功能的迭代器) Given an Iterator class interface with methods: next() and
	 * hasNext(), design and implement a PeekingIterator that support the peek()
	 * operation -- it essentially peek() at the element that will be returned
	 * by the next call to next().
	 * 
	 * Here is an example. Assume that the iterator is initialized to the
	 * beginning of the list: [1, 2, 3].
	 * 
	 * Call next() gets you 1, the first element in the list.
	 * 
	 * Now you call peek() and it returns 2, the next element. Calling next()
	 * after that still return 2.
	 * 
	 * You call next() the final time and it returns 3, the last element.
	 * Calling hasNext() after that should return false.
	 * 
	 * Hint:
	 * 
	 * Think of "looking ahead". You want to cache the next element.
	 * 
	 * Is one variable sufficient? Why or why not?
	 * 
	 * Test your design with call order of peek() before next() vs next() before
	 * peek().
	 * 
	 * For a clean implementation, check out Google's guava library source code.
	 */
	private Iterator<Integer> iterator;
	private Integer peek;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		if (iterator.hasNext())
			peek = iterator.next();
		else
			peek = null;
	}

	// Returns the next element in the iteration without advancing the
	// iterator.
	public Integer peek() {
		return peek;

	}

	// hasNext() and next() should behave the same as in the Iterator
	// interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer res = peek;
		if (iterator.hasNext())
			peek = iterator.next();
		else
			peek = null;
		return res;
	}

	@Override
	public boolean hasNext() {
		return peek != null;

	}

	@Override
	public void remove() {
		this.iterator.remove();
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Iterator<Integer> iterator = list.iterator();
		PeekingIterator peekingIterator = new PeekingIterator(iterator);

		while (peekingIterator.hasNext()) {
			System.out.println(peekingIterator.peek());
			System.out.println(peekingIterator.next());
		}

	}
}
