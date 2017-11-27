import java.util.*;

/**
 * Created by Metehan on 22.03.2017.
 */
public class myQueue<E> extends KWLinkedList<E> {
    ListIterator <E> start;
    ListIterator <E> end;

    /**
     * Counstructor
     */
    public myQueue(){
        super();
    }

    /**
     * This function reverses the given queue
     */
    public void reverse()
    {
        E tempData;
        int i = 0;
        start = listIterator(i);
        end = listIterator(size);
        for(i = 0;i<size/2;i++){
            tempData = start.next();
            start.previous();
            start.set(end.previous());
            end.next();
            end.set(tempData);
            start.next();
            end.previous();
        }
    }

    /**
     * This function reverses the given queue
     * @param queue given queue reference
     */
    public  void reverseQueue(Queue<E> queue){
        if(queue.isEmpty()){
            return;
        }
        else {
            E temp = queue.poll();
            reverseQueue(queue);
            queue.add(temp);
        }
    }


}
