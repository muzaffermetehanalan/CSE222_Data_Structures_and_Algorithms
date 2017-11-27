import java.util.ArrayList;

/**
 * Created by Metehan on 19.03.2017.
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E> {

    /**
     * This function removes last element,and returns removed element
     */
    @Override
    public E pop() {
        E tempObj = null;
        if(isEmpty()!=true) {
            return remove(size() - 1);
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
        add(obj);
        return obj;
    }

    /**
     * Constructor for stackA, calls super class's constructor
     */
    public StackA (){
        super();
    }


}
