import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Metehan on 21.03.2017.
 */
public class PriorityQueueA<E> extends LinkedList<E> {
    /**
     * This function returns false if queue is not empty or return true
     * @return returns false if queue is not empty or return true
     */
    public boolean isEmpty(){
        if(super.size()>0){
            return false;
        }
        return true;
    }

    /**
     * This function remove lowest value
     * @return remove priority data from queue
     */
    public E deleteMin(){
        PriorityQueueA.GenericCompare mycomparator = new PriorityQueueA.GenericCompare();
        E minValue;
        int tempIndex = 0;
        int i = 0 ;
        if(size()==1){
            return  super.removeFirst();
        }
        else{
            minValue = super.getFirst();
            if(minValue instanceof String || minValue instanceof Character){
                while(i<size()){
                    if(minValue.toString().compareTo(super.get(i).toString())>0){
                        minValue= super.get(i);
                        tempIndex = i;
                    }
                    ++i;
                }
                super.remove(tempIndex);
            }
            else{
                while(i<size()){
                    if(mycomparator.compare((Number) minValue,(Number)super.get(i))>0){
                        minValue=super.get(i);
                        tempIndex = i;
                    }
                    ++i;
                }
                super.remove(tempIndex);
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
