import java.util.LinkedList;
import java.math.BigDecimal;
import java.util.*;
/**
 * Created by Metehan on 21.03.2017.
 */
public class PriorityQueueB<E> {
    private LinkedList<E> priorityQueueList = new LinkedList<E>();

    /**
     * returns queue's size
     * @return size
     */
    public int size(){
        return priorityQueueList.size();
    }

    /**
     * @return if queue is empty returns true else false
     */
    public boolean isEmpty(){
        if(size()>0)
            return false;
        return true;
    }

    /**
     * Push given obj to the queue
     * @param obj Data to be stored
     * @return obj Added data
     */
    public E add(E obj){
        priorityQueueList.add(obj);
        return obj;
    }
    /**
     * This function remove lowest value
     * @return remove priority data from queue
     */
    public E deleteMin(){
        GenericCompare mycomparator = new GenericCompare();
        E minValue;
        int i = 0 ;
        int tempIndex = 0;
        if(size()==1){
           return  priorityQueueList.removeFirst();
        }
        else{
            minValue = priorityQueueList.getFirst();
            if(minValue instanceof String || minValue instanceof Character){
                while(i<size()){
                    if(minValue.toString().compareTo(priorityQueueList.get(i).toString())>0){
                        minValue= priorityQueueList.get(i);
                        tempIndex = i;
                    }
                    ++i;
                }
                priorityQueueList.remove(tempIndex);

            }
            else{
                ;while(i<size()){
                    if(mycomparator.compare((Number) minValue,(Number)priorityQueueList.get(i))>0){
                        minValue=priorityQueueList.get(i);
                        tempIndex = i;
                    }
                    ++i;
                }
                priorityQueueList.remove(tempIndex);
            }
        }
            return minValue;
        }
    /**
     * This class using for compare generic datas
     */
    class GenericCompare implements Comparator<Number> {

        public int compare(Number t1, Number t2){
            return new BigDecimal(t1.toString()).compareTo(new BigDecimal(t2.toString()));
        }

    }

}


