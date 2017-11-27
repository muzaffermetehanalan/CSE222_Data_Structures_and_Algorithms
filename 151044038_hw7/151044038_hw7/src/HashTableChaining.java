import java.util.LinkedList;
import java.util.Map;

/**
 * Created by syucer on 4/24/2017.
 */
public class HashTableChaining<K, V> implements HashMap<K, V> {
    /** The table */
    //private HashTableOpen<Entry<K, V>>[] table;
    //Do not forget you can use more class and methods to do this homework,
    // this project gives you an initial classes an methods to see easily
    //....
    //.... other class members
    /**
     * Data fields are taken from the Data Structures book. Page(391)
     */
    private LinkedList<Entry<K,V>>[] hashTable;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;
    private static class Entry<K,V>{
        private K key;
        private V value;
        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public V setValue(V val){
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }
    public HashTableChaining(){
        hashTable = new LinkedList[CAPACITY];
    }
    @Override
    public V get(Object key) {
        int givenIndex = key.hashCode() % hashTable.length;
        if(givenIndex < 0)
            givenIndex+= hashTable.length;
        if(hashTable[givenIndex]==null)
            return null;
        for(Entry<K,V> next : hashTable[givenIndex]){
            if(next.getKey().equals(key)){
                return next.getValue();
            }
        }
        return null;
    }
    @Override
    public V put(K key, V value) {
        int givenIndex = key.hashCode() % hashTable.length;
        if (givenIndex < 0)
            givenIndex += hashTable.length;
        if (hashTable[givenIndex] == null) {
            hashTable[givenIndex] = new LinkedList<Entry<K, V>>();
        }
        hashTable[givenIndex].addFirst(new Entry<K, V>(key,value));
        numKeys++;
        if(numKeys > (LOAD_THRESHOLD * hashTable.length)){
            rehash();
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        boolean found = false;
        int foundIndex = 0;
        int givenIndex = key.hashCode() % hashTable.length;
        if(givenIndex < 0)
            givenIndex+= hashTable.length;
        if(hashTable[givenIndex]==null)
            return null;

        for(Entry<K,V> next : hashTable[givenIndex]){
            if(next.getKey().equals(key)){
                V oldVal = next.getValue();
                hashTable[givenIndex].remove(foundIndex);
                found = true;
                numKeys--;
                return oldVal;
            }
            foundIndex++;
        }

            return null;
    }

    @Override
    public int size(){
        return numKeys;
    }

    @Override
    public boolean isEmpty() {
        return numKeys==0;
    }

    private void rehash(){
        LinkedList<Entry<K,V>>[] tempTable = hashTable;
        hashTable = new LinkedList[2*size()+1];
        hashTable = tempTable;
    }

}
