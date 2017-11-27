/**
 * Created by Metehan on 5.04.2017.
 */
import java.io.*;
import java.util.*;

public class TestBinaryTree {
    public static void main(String args[]){
        BinaryTree<Integer> preOrder= new BinaryTree<>();
        BinarySearchTree<Integer> levelOrder = new BinarySearchTree<>();
        File file = new File("test.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int insertIt = scanner.nextInt();
                preOrder.insert(insertIt);
                levelOrder.insert(insertIt);
            }
            scanner.close();
            System.out.print("Preorder Travers =");
            preOrder.preOrderTravers();
            System.out.print("Levelorder Travers =");
            levelOrder.levelOrderTravers();
        } catch( Exception e){
            System.out.println("Exception found = "+ e);
        }
    }
}
