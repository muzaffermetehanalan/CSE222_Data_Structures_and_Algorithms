/**
 * Created by Metehan on 10.03.2017.
 */
public class MyIterator<E>{
    SingleLinkedList<E> iteratorList = new SingleLinkedList<E>();
    int currentIndex = 0;
    public MyIterator(SingleLinkedList<E> list){
        iteratorList = list;
    }

    /**
     * If list has next link , returns true
     * @return true or false
     */
    public boolean hasNext(){
        if(currentIndex < iteratorList.getSize())
            return true;
        return false;
    }

    /**
     * Function returns next data
     * @return data List's next data
     */
    public E next(){
        return iteratorList.get(currentIndex++);
    }

}
