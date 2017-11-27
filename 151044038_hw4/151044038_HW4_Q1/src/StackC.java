/**
 * Created by Metehan on 19.03.2017.
 */

public class StackC<E>  implements StackInterface<E> {
    private Node<E> head = null;
    private int size;

    /**
     * This function removes last element,and returns removed element
     * @return if success delData , else temp
     */
    @Override
    public E pop() {
        int tempSize = size - 2;
        Node<E> tempList = head;
        try {
            if (head.getLink() == null) {
                E delData = head.getData();
                head = null;
                size--;
                return delData;
            } else {
                while (tempList.getLink().getLink() != null) {
                    tempList = tempList.getLink();
                }
                E delData = tempList.getLink().getData();
                tempList.setLink(null);
                size--;
                return delData;
            }
        }catch (NullPointerException e){
            System.out.println("Exception caught = "+ e);
        }
        E temp = null;
        return null;
    }

    /**
     * This function add elements to the end of stack
     * @param obj Arraylist object
     * @return obj Arraylist object (removed element)
     */
    @Override
    public E push(E obj) {
        if(size==0){
            head = new Node<E>(obj, head);
            size++;
        }
        else {
            Node<E> tempList = head;
            while(tempList.next != null){
                tempList = tempList.next;
            }
            Node<E> newElement = new Node<E>(obj);
            tempList.next = newElement;
            size++;
        }
        return obj;
    }
    /**
     * @return if stack is empty returns false, or returns true
     */
    @Override
    public boolean isEmpty() {
        if(size>0){
            return false;
        }
        return true;
    }
    /**
     * @return size Stack's size
     */
    @Override
    public int size() {
        return size;
    }
}
