/**
 * Created by syucer on 4/24/2017.
 */
import java.util.*;

public class BinaryNavMap<K,V> extends AbstractMap<K,V>
        implements NavigableMap<K,V>, Cloneable, java.io.Serializable
{
    private BinarySearchTree<Entry<K,V>> bst;

    public BinaryNavMap(){
        bst = new BinarySearchTree<>();
    }


    @Override
    public V put(K key, V value) {
        Map.Entry<K,V> entry =  new AbstractMap.SimpleEntry<K,V>(key,value);

        if(bst.root==null){
            bst.root = new BinaryTree.Node<Entry<K, V>>(entry);
            return value;
        }
        BinaryTree.Node<Entry<K,V>> current =bst.root;
        BinaryTree.Node<Entry<K,V>> temp = null;
        while(true){
            temp=current;
            if(current.data.getKey().toString().compareTo(key.toString())>0){
                current = current.left;
                if (current == null ) {
                    temp.left = new BinaryTree.Node<Entry<K, V>>(entry);
                    return value;
                }

            }
            else{
                current=current.right;
                if(current == null ){
                    temp.right = new BinaryTree.Node<Entry<K, V>>(entry);
                    return value;
                }
            }
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        bst.levelOrderTravers();
        for (int i = 0; i < bst.preOrderList.size(); i++) {
            set.add(bst.preOrderList.get(i));
        }
        return set;
    }

    /**
     * Returns a key-value mapping associated with the greatest key
     * strictly less than the given key, or {@code null} if there is
     * no such key.
     *
     * @param key the key
     * @return an entry with the greatest key less than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> lowerEntry(K key) {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        try {
            while(true){
                if(tempBst.getData().getKey() == key){
                    if(tempBst.getLeftSubtree().getData()!=null)
                        return tempBst.getLeftSubtree().getData();
                    else
                        return null;
                }
                else {
                    if(tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                        tempBst = tempBst.getLeftSubtree();
                    }
                    else {
                        tempBst = tempBst.getRightSubtree();
                    }
                }
            }

        }catch(Exception E){
            System.out.println(E);
        }
        return null;
    }

    /**
     * Returns the greatest key strictly less than the given key, or
     * {@code null} if there is no such key.
     *
     * @param key the key
     * @return the greatest key less than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K lowerKey(K key) {
        return lowerEntry(key).getKey();
    }
    /**
     * Returns a key-value mapping associated with the greatest key
     * less than or equal to the given key, or {@code null} if there
     * is no such key.
     *
     * @param key the key
     * @return an entry with the greatest key less than or equal to
     * {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> floorEntry(K key) {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        try {
            while(true){
                if(tempBst.getData().getKey() == key || tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                    return tempBst.getData();

                }
                else {
                    if(tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                        tempBst = tempBst.getLeftSubtree();
                    }
                    else {
                        tempBst = tempBst.getRightSubtree();
                    }
                }
            }

        }catch(Exception E){
            System.out.println(E);
        }
        return null;

    }
    /**
     * Returns the greatest key less than or equal to the given key,
     * or {@code null} if there is no such key.
     *
     * @param key the key
     * @return the greatest key less than or equal to {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K floorKey(K key) {
        return floorEntry(key).getKey();
    }
    /**
     * Returns a key-value mapping associated with the least key
     * greater than or equal to the given key, or {@code null} if
     * there is no such key.
     *
     * @param key the key
     * @return an entry with the least key greater than or equal to
     * {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> ceilingEntry(K key) {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        try {
            while(true){
                if(tempBst.getData().getKey() == key || tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                    return tempBst.getData();

                }
                else {
                    if(tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                        tempBst = tempBst.getLeftSubtree();
                    }
                    else {
                        tempBst = tempBst.getRightSubtree();
                    }
                }
            }

        }catch(Exception E){
            System.out.println(E);
        }
        return null;
    }
    /**
     * Returns the least key greater than or equal to the given key,
     * or {@code null} if there is no such key.
     *
     * @param key the key
     * @return the least key greater than or equal to {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K ceilingKey(K key) {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        try {
            while(true){
                if(tempBst.getData().getKey() == key || tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                    return tempBst.getData().getKey();

                }
                else {
                    if(tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                        tempBst = tempBst.getLeftSubtree();
                    }
                    else {
                        tempBst = tempBst.getRightSubtree();
                    }
                }
            }

        }catch(Exception E){
            System.out.println(E);
        }
        return null;
    }
    /**
     * Returns a key-value mapping associated with the least key
     * strictly greater than the given key, or {@code null} if there
     * is no such key.
     *
     * @param key the key
     * @return an entry with the least key greater than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> higherEntry(K key) {

        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        try {
            while(true){
                if(tempBst.getData().getKey() == key){
                    if(tempBst.getRightSubtree()!=null){
                        return tempBst.getRightSubtree().getData();
                    }
                    return null;
                }
                else {
                    if(tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                        tempBst = tempBst.getLeftSubtree();
                    }
                    else {
                        tempBst = tempBst.getRightSubtree();
                    }
                }
            }

        }catch(Exception E){
            System.out.println(E);
        }
        return null;
    }

    /**
     * Returns the least key strictly greater than the given key, or
     * {@code null} if there is no such key.
     *
     * @param key the key
     * @return the least key greater than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K higherKey(K key) {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        try {
            while(true){
                if(tempBst.getData().getKey() == key){
                    if(tempBst.getRightSubtree()!=null){
                        return tempBst.getRightSubtree().getData().getKey();
                    }
                    return null;
                }
                else {
                    if(tempBst.getData().getKey().toString().compareTo(key.toString())>0){
                        tempBst = tempBst.getLeftSubtree();
                    }
                    else {
                        tempBst = tempBst.getRightSubtree();
                    }
                }
            }

        }catch(Exception E){
            System.out.println(E);
        }
        return null;

    }

    /**
     * Returns a key-value mapping associated with the least
     * key in this map, or {@code null} if the map is empty.
     *
     * @return an entry with the least key,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> firstEntry() {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        while(tempBst.getLeftSubtree()!=null){
            tempBst = tempBst.getLeftSubtree();
        }
        return tempBst.getData();
    }

    /**
     * Returns a key-value mapping associated with the greatest
     * key in this map, or {@code null} if the map is empty.
     *
     * @return an entry with the greatest key,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> lastEntry() {
        BinaryTree<Entry<K,V>> tempBst = new BinaryTree<>();
        tempBst = bst;
        while(tempBst.getRightSubtree()!=null){
            tempBst = tempBst.getRightSubtree();
        }
        return tempBst.getData();
    }
    /**
     * Removes and returns a key-value mapping associated with
     * the least key in this map, or {@code null} if the map is empty.
     *
     * @return the removed first entry of this map,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> pollFirstEntry() {
        Map.Entry<K,V> entry;
        BinaryTree.Node<Entry<K,V>> tempBst=bst.root;
        while (true) {
            if (tempBst.left.data != null) {
                tempBst = tempBst.left;
            }
            if(tempBst.left == null || tempBst.left.data == null){
                entry = new AbstractMap.SimpleEntry<K,V>(tempBst.data.getKey(),tempBst.data.getValue());
                if(tempBst==bst.root){
                    if(bst.root.right != null){
                        bst.root = bst.root.right;
                    }
                }
                tempBst.data = null;
                return entry;
            }
        }
    }

    /**
     * Removes and returns a key-value mapping associated with
     * the greatest key in this map, or {@code null} if the map is empty.
     *
     * @return the removed last entry of this map,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> pollLastEntry() {
        Map.Entry<K,V> entry;
        BinaryTree.Node<Entry<K,V>> tempBst=bst.root;
        while (true) {
            if (tempBst.right!=null) {
                tempBst = tempBst.right;
            }
            if(tempBst.right == null || tempBst.right.data == null){
                entry = new AbstractMap.SimpleEntry<K,V>(tempBst.data.getKey(),tempBst.data.getValue());
                if(tempBst==bst.root){
                    if(bst.root.left != null){
                        bst.root = bst.root.left;
                    }
                }
                tempBst.data = null;
                return entry;
            }
        }

    }

    /**
     * Returns a reverse order view of the mappings contained in this map.
     * The descending map is backed by this map, so changes to the map are
     * reflected in the descending map, and vice-versa.  If either map is
     * modified while an iteration over a collection view of either map
     * is in progress (except through the iterator's own {@code remove}
     * operation), the results of the iteration are undefined.
     * <p>
     * <p>The returned map has an ordering equivalent to
     * <tt>{@link Collections#reverseOrder(Comparator) Collections.reverseOrder}(comparator())</tt>.
     * The expression {@code m.descendingMap().descendingMap()} returns a
     * view of {@code m} essentially equivalent to {@code m}.
     *
     * @return a reverse order view of this map
     */
    private transient NavigableMap<K,V> descendingMap = null;
    @Override
    public NavigableMap<K, V> descendingMap() {
        Set<Entry<K, V>> set = entrySet();
        NavigableMap<K, V> map = new TreeMap<K, V>();
        Iterator<Entry<K, V>> it = set.iterator();
        while (it.hasNext()) {
            Entry<K, V> entry = it.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map.descendingMap();
    }
    /**
     * Returns a {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in ascending order.
     * The set is backed by the map, so changes to the map are reflected in
     * the set, and vice-versa.  If the map is modified while an iteration
     * over the set is in progress (except through the iterator's own {@code
     * remove} operation), the results of the iteration are undefined.  The
     * set supports element removal, which removes the corresponding mapping
     * from the map, via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
     * It does not support the {@code add} or {@code addAll} operations.
     *
     * @return a navigable set view of the keys in this map
     */
    @Override
    public NavigableSet<K> navigableKeySet() {
        Set<Entry<K, V>> set = entrySet();
        NavigableSet<K> tempSet = new TreeSet<K>();
        NavigableMap<K, V> map = new TreeMap<K, V>();
        Iterator<Entry<K, V>> it = set.iterator();
        while (it.hasNext()) {
            Entry<K, V> entry = it.next();
            tempSet.add(entry.getKey());
        }
        return tempSet;
    }

    /**
     * Returns a reverse order {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in descending order.
     * The set is backed by the map, so changes to the map are reflected in
     * the set, and vice-versa.  If the map is modified while an iteration
     * over the set is in progress (except through the iterator's own {@code
     * remove} operation), the results of the iteration are undefined.  The
     * set supports element removal, which removes the corresponding mapping
     * from the map, via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
     * It does not support the {@code add} or {@code addAll} operations.
     *
     * @return a reverse order navigable set view of the keys in this map
     */
    @Override
    public NavigableSet<K> descendingKeySet() {
            Set<Entry<K, V>> set = entrySet();
            NavigableSet<K> tempSet = new TreeSet<K>();
            NavigableMap<K, V> map = new TreeMap<K, V>();
            Iterator<Entry<K, V>> it = set.iterator();
            while (it.hasNext()) {
                Entry<K, V> entry = it.next();
                tempSet.add(entry.getKey());
            }
            return tempSet.descendingSet();
    }
    /**
     * Returns a view of the portion of this map whose keys range from
     * {@code fromKey} to {@code toKey}.  If {@code fromKey} and
     * {@code toKey} are equal, the returned map is empty unless
     * {@code fromInclusive} and {@code toInclusive} are both true.  The
     * returned map is backed by this map, so changes in the returned map are
     * reflected in this map, and vice-versa.  The returned map supports all
     * optional map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside of its range, or to construct a
     * submap either of whose endpoints lie outside its range.
     *
     * @param fromKey       low endpoint of the keys in the returned map
     * @param fromInclusive {@code true} if the low endpoint
     *                      is to be included in the returned view
     * @param toKey         high endpoint of the keys in the returned map
     * @param toInclusive   {@code true} if the high endpoint
     *                      is to be included in the returned view
     * @return a view of the portion of this map whose keys range from
     * {@code fromKey} to {@code toKey}
     * @throws ClassCastException       if {@code fromKey} and {@code toKey}
     *                                  cannot be compared to one another using this map's comparator
     *                                  (or, if the map has no comparator, using natural ordering).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromKey} or {@code toKey}
     *                                  cannot be compared to keys currently in the map.
     * @throws NullPointerException     if {@code fromKey} or {@code toKey}
     *                                  is null and this map does not permit null keys
     * @throws IllegalArgumentException if {@code fromKey} is greater than
     *                                  {@code toKey}; or if this map itself has a restricted
     *                                  range, and {@code fromKey} or {@code toKey} lies
     *                                  outside the bounds of the range
     */
    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        Set<Entry<K, V>> set = entrySet();
        Iterator<Entry<K, V>> it = set.iterator();
        NavigableMap<K,V> map = new TreeMap<K, V>();
        boolean flag = false;
        while(it.hasNext()) {
            Entry<K, V> entry = it.next();
            if (entry.getKey().equals(fromKey)) {
                if (fromInclusive == true) {
                    map.put(entry.getKey(), entry.getValue());
                    flag = true;
                }
            }
            if (flag == true && entry.getKey().equals(toKey)) {
                if (toInclusive == true) {
                    map.put(entry.getKey(), entry.getValue());

                }
                break;
            } else if (flag == true) {
                map.put(entry.getKey(), entry.getValue());
            }

            if (!it.hasNext() && flag == true) {
                it = set.iterator();
            }
        }
        return map;
    }

    /**
     * Returns a view of the portion of this map whose keys are less than (or
     * equal to, if {@code inclusive} is true) {@code toKey}.  The returned
     * map is backed by this map, so changes in the returned map are reflected
     * in this map, and vice-versa.  The returned map supports all optional
     * map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param toKey     high endpoint of the keys in the returned map
     * @param inclusive {@code true} if the high endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this map whose keys are less than
     * (or equal to, if {@code inclusive} is true) {@code toKey}
     * @throws ClassCastException       if {@code toKey} is not compatible
     *                                  with this map's comparator (or, if the map has no comparator,
     *                                  if {@code toKey} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code toKey} cannot be compared to keys
     *                                  currently in the map.
     * @throws NullPointerException     if {@code toKey} is null
     *                                  and this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *                                  restricted range, and {@code toKey} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        Set<Entry<K, V>> set = entrySet();
        NavigableSet<K> tempSet = new TreeSet<K>();
        NavigableMap<K, V> map = new TreeMap<K, V>();
        NavigableMap<K, V> retMap = new BinaryNavMap<K,V>();
        Iterator<Entry<K, V>> it = set.iterator();
        while (it.hasNext()) {
            Entry<K, V> entry = it.next();
            map.put(entry.getKey(),entry.getValue());
        }
        Set<Entry<K,V>> sets =  map.entrySet();
        Iterator<Entry<K, V>> iterator = sets.iterator();
        while(iterator.hasNext()){
            Entry<K, V> entry = it.next();
            if(!entry.getKey().equals(toKey)){
                retMap.put(entry.getKey(),entry.getValue());
            }
            else{
                if(inclusive==true){
                    retMap.put(entry.getKey(),entry.getValue());
                }
            }
        }
        return retMap;
    }

    /**
     * Returns a view of the portion of this map whose keys are greater than (or
     * equal to, if {@code inclusive} is true) {@code fromKey}.  The returned
     * map is backed by this map, so changes in the returned map are reflected
     * in this map, and vice-versa.  The returned map supports all optional
     * map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey   low endpoint of the keys in the returned map
     * @param inclusive {@code true} if the low endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this map whose keys are greater than
     * (or equal to, if {@code inclusive} is true) {@code fromKey}
     * @throws ClassCastException       if {@code fromKey} is not compatible
     *                                  with this map's comparator (or, if the map has no comparator,
     *                                  if {@code fromKey} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromKey} cannot be compared to keys
     *                                  currently in the map.
     * @throws NullPointerException     if {@code fromKey} is null
     *                                  and this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *                                  restricted range, and {@code fromKey} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;
    }

    /**
     * Returns the comparator used to order the keys in this map, or
     * {@code null} if this map uses the {@linkplain Comparable
     * natural ordering} of its keys.
     *
     * @return the comparator used to order the keys in this map,
     * or {@code null} if this map uses the natural ordering
     * of its keys
     */
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code subMap(fromKey, true, toKey, false)}.
     *
     * @param fromKey
     * @param toKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return subMap(fromKey,true,toKey,false);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code headMap(toKey, false)}.
     *
     * @param toKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code tailMap(fromKey, true)}.
     *
     * @param fromKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    /**
     * Returns the first (lowest) key currently in this map.
     *
     * @return the first (lowest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    @Override
    public K firstKey() {
        return firstEntry().getKey();
    }

    /**
     * Returns the last (highest) key currently in this map.
     *
     * @return the last (highest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    @Override
    public K lastKey() {
        return lastEntry().getKey();
    }
}