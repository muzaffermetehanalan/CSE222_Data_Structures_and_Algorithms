import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * Created by Metehan on 19.03.2017.
 */
public class StackB<E> implements StackInterface<E> {
    private ArrayList<E> stackObj = new ArrayList<E>();
    /**
     * This function removes last element,and returns removed element
     */
    @Override
    public E pop() {
            E tempObj = null;
            if(stackObj.isEmpty()!=true) {
                return stackObj.remove(size() - 1);
            }
            return tempObj;
    }
    /**
     * This function add elements to the end of stack
     * @param obj Arraylist object
     * @return obj Arraylist object (removed element)
     */
    @Override
    public E push(E obj) {
        stackObj.add(obj);
        return obj;
    }

    /**
     * @return if stack is empty returns false, or returns true
     */
    @Override
    public boolean isEmpty() {
        return stackObj.isEmpty();
    }

    /**
     * @return size Stack's size
     */
    @Override
    public int size() {
        return stackObj.size();
    }


}
