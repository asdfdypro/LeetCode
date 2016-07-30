package asdf.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asdf on 2016/7/30.
 */
public class NestedIntegerImpl implements NestedInteger {

    int val;
    List<NestedInteger> list;

    public NestedIntegerImpl(int val) {
        this.val = val;
    }

    public NestedIntegerImpl(int[] vals) {
        this.list = new ArrayList<>();
        for (int val : vals) {
this.list.add(new NestedIntegerImpl(val));
        }
    }


    @Override
    public boolean isInteger() {
        return this.list==null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
