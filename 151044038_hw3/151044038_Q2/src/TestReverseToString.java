/**
 * Created by Metehan on 11.03.2017.
 */

/**
 * This class tests reversToString method which belongs to
 * SingleLinkedList class
 */
public class TestReverseToString {
    /**
     * Fills integerList with 50 integers and display
     * normal sequence and reversed sequence of list
     * Fills stringList with 4 strings  display normal
     * sequence and reverse sequence of list
     * @param args
     */
    public static void main(String args[]){
        SingleLinkedList<Integer> integerList = new SingleLinkedList<Integer>();
        SingleLinkedList<String> stringList = new SingleLinkedList<String>();
        for(int i= 0 ; i < 50 ; i++){
            integerList.add(i);
        }
        stringList.add("Data");
        stringList.add("Structures");
        stringList.add("And");
        stringList.add("Algorithms");

        System.out.println(integerList.toString());
        System.out.println(integerList.reverseToString());

        System.out.println(stringList.toString());
        System.out.println(stringList.reverseToString());

    }
}
