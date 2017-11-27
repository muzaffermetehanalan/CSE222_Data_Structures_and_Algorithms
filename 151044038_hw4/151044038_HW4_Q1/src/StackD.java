/**
 * Created by Metehan on 19.03.2017.
 */

import java.util.LinkedList;
import java.util.Queue;
@SuppressWarnings("Unchecked")
public class StackD<E>  implements StackInterface<E>{
    private Queue<E> stackObj = new LinkedList<E>();
    /**
     * This function removes last element,and returns removed element
     */
    @Override
    public E pop() {
        if(stackObj.isEmpty()!=true)
            return removeHelper();
        E tempObj = null;
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

    /**
     * This function removes last element and returns removed element
     * @return temp Temp array
     */
    private E removeHelper(){
        E [] temp = null;
        temp = (E[])stackObj.toArray();
        stackObj = null;
        stackObj = new LinkedList<E>();
        int x =  temp.length;
        for(int i=0;i<x-1;i++){
            stackObj.add(temp[i]);
        }
        return temp[x-1];
    }
}