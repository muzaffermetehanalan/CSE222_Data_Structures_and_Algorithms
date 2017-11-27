import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BinaryTree< E>  implements Serializable , Iterable <E> {

   private class myIterator <E> implements Iterator<E> {
       ArrayList <E> preOrderIterList = null;
       /**
        * myIterator constructor.
        * Verilen listeyi iteratorun listesine atamasini yapar.
        * @param givenList Travers edilmis liste
        */
       private myIterator(ArrayList<E> givenList){
         preOrderIterList = new ArrayList(givenList);
       }
       /**
        * Listede eleman kalip kalmamasina bakar
        * @return eger eleman varsa true , yoksa false return eder
        */
       public boolean hasNext() {
           if(preOrderIterList.size()==0){
               return false;
           }
           return true;
      }
       /**
        * Iterator gosterdigi node u return eder , ve bir sonraki node u gosterir
        * @return temp Iteratorun gosterdigi yerin datasi
        */
       public E next() {
          E temp = preOrderIterList.get(0);
          preOrderIterList.remove(0);
          return temp;
      }


  }
    public Iterator<E> iterator() {
        return new myIterator<E>(preOrderList);
    }

  /** Class to encapsulate a tree node. */
  protected static class Node < E >
      implements Serializable {
    // Data Fields
    /** The information stored in this node. */
    protected E data;

    /** Reference to the left child. */
    protected Node < E > left;

    /** Reference to the right child. */
    protected Node < E > right;

    // Constructors
    /** Construct a node with given data and no children.
        @param data The data to store in this node
     */
    public Node(E data) {
      this.data = data;
      left = null;
      right = null;
    }

    // Methods
    /** Return a string representation of the node.
        @return A string representation of the data fields
     */
    public String toString() {
      return data.toString();
    }
  }

  // Data Field
  /** The root of the binary tree */
  protected Node < E > root;
  Stack<Node<E>> preOrderStack = null;
  ArrayList<E> preOrderList = null;

  public BinaryTree() {
    root = null;
  }

  protected BinaryTree(Node < E > root) {
    this.root = root;
  }

  /** Constructs a new binary tree with data in its root,leftTree
      as its left subtree and rightTree as its right subtree.
   */
  public BinaryTree(E data, BinaryTree< E > leftTree,
                    BinaryTree< E > rightTree) {
    root = new Node < E > (data);
    if (leftTree != null) {
      root.left = leftTree.root;
    }
    else {
      root.left = null;
    }
    if (rightTree != null) {
      root.right = rightTree.root;
    }
    else {
      root.right = null;
    }
  }

  /** Return the left subtree.
      @return The left subtree or null if either the root or
      the left subtree is null
   */
  public BinaryTree< E > getLeftSubtree() {
    if (root != null && root.left != null) {
      return new BinaryTree< E >(root.left);
    }
    else {
      return null;
    }
  }

  /** Return the right sub-tree
        @return the right sub-tree or
        null if either the root or the
        right subtree is null.
    */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }
    /**
     * Bu fonksiyon verilen agacin derinligini hesaplar
     * @param root Treenin root'u
     * @return lDepth veya rDepth
     */
    private int depth(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            int lDepth = depth(root.left);
            int rDepth = depth(root.right);

            if (lDepth > rDepth) {
                return lDepth + 1;
            } else {
                return rDepth + 1;
            }
        }
    }
    /**
     * Bu fonksiyon treenin derinligini return eder
     * @return depth(root)
     */
    public int getDepth(){
        return depth(root);
    }
    /**
     * Bu fonksiyon travers edilmis agaci iterator ile ekrana basar
     */
    public void preOrderTravers(){
        try {
            preOrderTravers(root);
            Iterator<E> traverIter = iterator();
            while (traverIter.hasNext()) {
                System.out.print(traverIter.next());
                if (traverIter.hasNext()) {
                    System.out.print(" , ");
                }
                else {
                    System.out.println();
                }
            }
        }catch( Exception e){
            System.out.println("Exception found = "+ e);
        }
    }
    /**
     * Bu fonksiyon verilen treeyi , preorder travers eder
     * @param root Treenin root'u
     * @return preOrderList travers edilmis liste
     */
    private ArrayList<E> preOrderTravers(Node<E> root){
        if(root==null){
            return null;
        }
        preOrderStack = new Stack();
        preOrderList  = new ArrayList();
        preOrderStack.push(root);
        while(!preOrderStack.empty()){
            Node <E> temp = preOrderStack.pop();
            preOrderList.add(temp.data);

            if(temp.right!=null){
                preOrderStack.push(temp.right);
            }
            if(temp.left!=null){
                preOrderStack.push(temp.left);
            }
        }
        return preOrderList;
    }
    /**
     * Bu fonksiyon treeye yeni eleman eklenmesini saglar
     * Dongu icerisinde ilerleyerek ekleme yapar
     * @param item Eklenecek olan data
     */
    public void insert(E item){
        if(root==null){
            root = new Node < E > (item);
            return;
        }
        Node<E> current = root;
        Node<E> temp = null;
        while(true){
            temp=current;
            if(current.data.toString().compareTo(item.toString())>0){
                current = current.left;
                if (current == null) {
                    temp.left = new Node<E>(item);
                    return;
                }

            }
            else{
                System.out.println(current + " "+ item);
                current=current.right;
                if(current == null ){
                    temp.right = new Node<E>(item);
                    return;
                }

            }
        }
    }

  /** Return the data field of the root
        @return the data field of the root
        or null if the root is null
    */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }
  /**** END EXERCISE ****/

  /** Determine whether this tree is a leaf.
      @return true if the root has no children
   */
  public boolean isLeaf() {
    return (root.left == null && root.right == null);
  }

  /** Method to read a binary tree.
      pre: The input consists of a preorder traversal
           of the binary tree. The line "null" indicates a null tree.
      @param bR The input file
      @return The binary tree
      @throws IOException If there is an input error
   */
  public static BinaryTree< String >
      readBinaryTree(BufferedReader bR) throws IOException {
    // Read a line and trim leading and trailing spaces.
    String data = bR.readLine().trim();
    if (data.equals("null")) {
      return null;
    }
    else {
      BinaryTree< String > leftTree = readBinaryTree(bR);
      BinaryTree< String > rightTree = readBinaryTree(bR);
      return new BinaryTree< String >(data, leftTree, rightTree);
    }
  }
    GenericCompare mycomparator = new GenericCompare();
    class GenericCompare implements Comparator<Number> {
        /**
         * Verilen 2 generic tipi kiyaslar
         * @param t1 verilen 1. generic data
         * @param t2 verilen 2.generic data
         * @return eger t1 buyukse 0 dan buyuk , t2 buyukse 0 dan kucuk deger return eder
         */
        public int compare(Number t1, Number t2){
            return new BigDecimal(t1.toString()).compareTo(new BigDecimal(t2.toString()));
        }

    }

}
