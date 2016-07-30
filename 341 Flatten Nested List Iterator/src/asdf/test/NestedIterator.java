package asdf.test;

import java.util.*;

/**
 * (嵌套数组)
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator> stack;
    private Iterator<NestedInteger> pos;//next始终指向叶子节点
    private NestedInteger nextInteger;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pos = nestedList.iterator();
    }

    @Override
    public Integer next() {
        return this.nextInteger.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (true) {
            while (!pos.hasNext() && !stack.isEmpty())
                pos = stack.pop();
            if (!pos.hasNext())
                return false;

            nextInteger = pos.next();


            if (nextInteger.isInteger())
                return true;

            stack.push(pos);
            pos = nextInteger.getList().iterator();
        }
    }

    public static void main(String[] args) {

        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedIntegerImpl(new int[]{1, 1}));
        list.add(new NestedIntegerImpl(2));
        list.add(new NestedIntegerImpl(new int[]{1, 1}));


        NestedIterator nestedIterator = new NestedIterator(list);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
        System.out.println("==============");

        list = new ArrayList<>();
        list.add(new NestedIntegerImpl(new int[]{}));//空

        nestedIterator = new NestedIterator(list);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
        System.out.println("==============");

        list = new ArrayList<>();
        list.add(new NestedIntegerImpl(new int[]{1,2}));
        list.add(new NestedIntegerImpl(new int[]{3}));//单个元素
        list.add(new NestedIntegerImpl(new int[]{4,5,6}));

        nestedIterator = new NestedIterator(list);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }




    }

}
