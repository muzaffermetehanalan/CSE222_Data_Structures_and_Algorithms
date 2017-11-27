/**
 * Created by Metehan on 19.03.2017.
 */
public interface StackInterface<E> {
    public  E  pop();
    public  E push(E obj);
    public boolean isEmpty();
    public int size();
}
