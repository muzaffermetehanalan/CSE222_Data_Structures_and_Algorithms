import java.util.*;

/**
 * Created by Metehan on 11.03.2017.
 */
public  class MyAbstractCollection  extends AbstractCollection {

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public  void appendAnything(AbstractCollection  firstObject ,AbstractCollection secondObject){
        firstObject.addAll(secondObject);
    }
}
