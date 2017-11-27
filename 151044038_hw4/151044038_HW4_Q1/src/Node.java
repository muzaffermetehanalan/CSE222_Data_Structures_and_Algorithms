/**
 * Created by Metehan on 21.03.2017.
 */
public class Node<E>{
    /** The reference to the data */
    protected E data;
    /** The reference to the next node*/
    protected Node<E> next;

    /**
     * Creates a new node with a null next field
     * @param dataItem The data stored
     */
    public Node(E dataItem){
        data = dataItem;
        next = null;
    }
    /**
     * Creates a new node that references another node
     * @param dataItem The data stored
     * @param nodeRef  The node referenced by new node
     */
    public Node(E dataItem , Node<E> nodeRef){
        data = dataItem;
        next = nodeRef;
    }

    /**
     * Sets the given nodeRef to node's next
     * @param nodeRef The node referenced by new node
     */
    public void setLink(Node<E> nodeRef)
    {
        next = nodeRef;
    }

    /**
     * Sets the given dataItem to node's data
     * @param dataItem The data stored
     */
    public void setData(E dataItem)
    {
        data = dataItem;
    }

    /**
     * Returns node's next link
     * @return next The node referenced by new node
     */
    public Node<E> getLink() {
        return next;
    }
    /**
     * Returns node's data
     * @return data The data stored
     */
    public E getData()
    {
        return data;
    }
}