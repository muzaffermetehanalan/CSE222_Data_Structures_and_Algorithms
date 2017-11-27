/**
 * Created by Metehan on 10.03.2017.
 */
public class MyStringBuilder<E> {
    SingleLinkedList<E> builderList = new SingleLinkedList<E>();

    /**
     * This function append anything to the list
     * @param item data to be store
     * @return true or false
     */
    public boolean appendAnything(E item){
        return builderList.add(item);
    }

    /**
     * This function returns string of list with
     * using indexes
     * @return tempStr
     */
    public String toStringWithIndex(){
        String tempStr = new String();
        for(int i= 0; i < builderList.getSize();i++) {
            tempStr += builderList.get(i);
            tempStr += " ";
        }
        return tempStr;
    }

    /**
     * This function returns string of list with
     * using linked list's toString
     * @return tempStr
     */
    public String toStringOfLinkedList() {
        String tempStr = builderList.toString();
        return tempStr;
    }

    /**
     * This function returns string of list with
     * using iterator
     * @return tempStr;
     */
    public String toStringWithIterator(){
        String tempStr = new String();
        MyIterator<E> listIt = new MyIterator<E>(builderList);
        while(listIt.hasNext()){
            tempStr += listIt.next();
            tempStr += " ";
        }
        return tempStr;

    }

}
