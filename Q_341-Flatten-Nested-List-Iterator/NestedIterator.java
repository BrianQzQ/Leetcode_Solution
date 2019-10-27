import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> s = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            s.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger t = s.pop();
        return t.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!s.empty()) {
            NestedInteger t = s.peek();
            if (t.isInteger()) return true;
            s.pop();
            for (int i = t.getList().size() - 1; i >= 0; i--) {
                s.push(t.getList().get(i));
            }
        }
        return false;
    }
}