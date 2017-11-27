/**
 * Created by Metehan on 10.03.2017.
 */
import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class TestStringBuilder {
    public static void main(String args[]){
        String linkedListToString;
        String indexToString;
        String iteratorToString;
        MyStringBuilder<Integer> myList = new MyStringBuilder<Integer>();
        try {
            Scanner scanner = new Scanner(new File("numbers.txt"));
            while(scanner.hasNextInt()){
                myList.appendAnything(scanner.nextInt());
            }
            scanner.close();
        }catch (Exception e){
            System.out.println(e);
        }
        linkedListToString = myList.toStringOfLinkedList();
        indexToString = myList.toStringWithIndex();
        iteratorToString = myList.toStringWithIterator();

        try {
            PrintWriter outList = new PrintWriter("result1.txt");
            PrintWriter outIndex = new PrintWriter("result2.txt");
            PrintWriter outIterator = new PrintWriter("result3.txt");

            outList.println(linkedListToString);
            outIndex.println(indexToString);
            outIterator.println(iteratorToString);

            outList.close();
            outIndex.close();
            outIterator.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
