/**
 * Created by Metehan on 10.03.2017.
 */
public class SingleLinkedList<E> {
    /**
     * Reference to list head.
     */
    private Node<E> head = null;
    private String reversedString = new String();
    /**
     * The number o items in the list
     */
    private int size;
    private int tempSize;
    /**
     * Add an item to the front of the list.
     *
     * @param item The item to be added
     */
    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }
    /**
     *
     * @param node The node preceding the new item
     * @param item The item to insert
     */
    private void addAfter(Node <E> node , E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }
    /**
     *
     * @param node The node before the one to be removed
     */
    private E removeAfter(Node <E> node){
        Node<E> temp = node.next;
        if(temp!=null){
            node.next = temp.next;
            size--;
            return temp.data;
        }
        else {
            return null;
        }
    }

    /**
     *  This function remove first node
     * @return data
     */
    private E removeFirst(){
        Node<E> temp = head;
        if(head != null){
            head = head.next;
        }
        if(temp!=null){
            size--;
            return temp.data;
        }
        else{
            return null;
        }
    }
    @Override
    /**
     * This function returns linked list's
     * datas.
     */
    public String toString(){
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();
        while(nodeRef!=null){
            result.append(nodeRef.data);
            if(nodeRef.next !=null){
                result.append(" ");
            }
            nodeRef = nodeRef.next;
        }
        return result.toString();
    }

    /**
     * This function returns given index's node
     * @param index
     * @return node
     */
    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i=0;i<index && node != null ; i++){
            node=node.next;
        }
        return node;
    }

    /**
     * This function returns given index's data
     * @param index
     * @return data
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * This function set's value of given node
     * @param index
     * @param newValue
     * @return result
     */
    public E set(int index,E newValue){
        if(index < 0 || index>= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * This function add new node to the given index
     * @param index
     * @param item
     */
    public void add(int index,E item){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0){
            addFirst(item);
        }
        else{
            Node<E> node = getNode(index-1);
            addAfter(node,item);
        }
    }

    /**
     * This function add new node to the list
     * @param item
     * @return true
     */
    public boolean add(E item){
        add(size,item);
        return true;
    }
    /**
     * This function returns list's size
     * @return size Length of list
     */
    public int getSize(){
        return size;
    }

    /**
     * This function returns string which reversed sequence of list
     * @return if size equals 0 then returns reversedString
     * else return reverseToString recursively
     */
    public String reverseToString(){
        if(size == 0){
            size = tempSize;
            String tempReversedString = reversedString;
            reversedString = new String();
            return tempReversedString;
        }
        else{
            reversedString += get(size-1);
            reversedString += " ";
            --size;
            tempSize++;
            return reverseToString();
        }
    }
}


