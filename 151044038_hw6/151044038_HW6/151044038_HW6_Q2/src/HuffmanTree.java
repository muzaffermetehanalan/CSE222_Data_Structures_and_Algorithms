import java.util.*;
import java.io.*;

/** Class to represent and build a Huffman tree.
*   @author Koffman and Wolfgang
* */

public class HuffmanTree
    implements Serializable {

  // Nested Classes
  /** A datum in the Huffman tree. */
  public static class HuffData
      implements Serializable {
    // Data Fields
    /** The weight or probability assigned to this HuffData. */
    private double weight;

    /** The alphabet symbol if this is a leaf. */
    private Character symbol;

    public HuffData(double weight, Character symbol) {
      this.weight = weight;
      this.symbol = symbol;
    }
  }

  // Data Fields
  /** A reference to the completed Huffman tree. */
  private BinaryTree < HuffData > huffTree;
  Stack<BinaryTree.Node<HuffData>> preOrderStack = null;
  ArrayList<BinaryTree.Node<HuffData>> preOrderList = null;

  /** A Comparator for Huffman trees; nested class. */
  private static class CompareHuffmanTrees
      implements Comparator < BinaryTree < HuffData >> {
    /** Compare two objects.
        @param treeLeft The left-hand object
        @param treeRight The right-hand object
        @return -1 if left less than right,
                0 if left equals right,
                and +1 if left greater than right
     */
    public int compare(BinaryTree < HuffData > treeLeft,
                       BinaryTree < HuffData > treeRight) {
      double wLeft = treeLeft.getData().weight;
      double wRight = treeRight.getData().weight;
      return Double.compare(wLeft, wRight);
    }
  }

  /** Builds the Huffman tree using the given alphabet and weights.
      post:  huffTree contains a reference to the Huffman tree.
      @param symbols An array of HuffData objects
   */
  public void buildTree(HuffData[] symbols) {
    Queue < BinaryTree < HuffData >> theQueue
        = new PriorityQueue < BinaryTree < HuffData >>
        (symbols.length, new CompareHuffmanTrees());
    // Load the queue with the leaves.
    for (HuffData nextSymbol : symbols) {
      BinaryTree < HuffData > aBinaryTree =
          new BinaryTree < HuffData > (nextSymbol, null, null);
      theQueue.offer(aBinaryTree);
    }

    // Build the tree.
    while (theQueue.size() > 1) {
      BinaryTree < HuffData > left = theQueue.poll();
      BinaryTree < HuffData > right = theQueue.poll();
      double wl = left.getData().weight;
      double wr = right.getData().weight;
      HuffData sum = new HuffData(wl + wr, null);
      BinaryTree < HuffData > newTree =
          new BinaryTree < HuffData > (sum, left, right);
      theQueue.offer(newTree);
    }

    // The queue should now contain only one item.
    huffTree = theQueue.poll();
  }

  /** Outputs the resulting code.
      @param out A PrintStream to write the output to
      @param code The code up to this node
      @param tree The current node in the tree
   */
  private void printCode(PrintStream out, String code,
                         BinaryTree < HuffData > tree) {
    HuffData theData = tree.getData();
    if (theData.symbol != null) {
      if (theData.symbol.equals(" ")) {
        out.println("space: " + code);
      }
      else {
        out.println(theData.symbol + ": " + code);
      }
    }
    else {
      printCode(out, code + "0", tree.getLeftSubtree());
      printCode(out, code + "1", tree.getRightSubtree());
    }
  }

  /** Method to decode a message that is input as a string of
      digit characters '0' and '1'.
      @param codedMessage The input message as a String of
                          zeros and ones.
      @return The decoded message as a String
   */
  public String decode(String codedMessage) {
    StringBuilder result = new StringBuilder();
    BinaryTree < HuffData > currentTree = huffTree;
    for (int i = 0; i < codedMessage.length(); i++) {
      if (codedMessage.charAt(i) == '1') {
        currentTree = currentTree.getRightSubtree();
      }
      else {
        currentTree = currentTree.getLeftSubtree();
      }
      if (currentTree.isLeaf()) {
        HuffData theData = currentTree.getData();
        result.append(theData.symbol);
        currentTree = huffTree;
      }
    }
    return result.toString();
  }

    /**
     * This function returns encoded message
     * @param message ths will be encode and return
     * @return stringBuilder encoded message
     */
  public String encode(String message){
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0;i<message.length();i++){
        BinaryTree < HuffData > currentTree = huffTree;
        StringBuilder strBuild= new StringBuilder();
        encodeMessage(message.charAt(i),currentTree,"",strBuild);
        stringBuilder.append(strBuild.toString());
    }
    return stringBuilder.toString();
  }

    /**
     * This function encodes message with recursion
     * @param charofMessage given char
     * @param currentTree tree node
     * @param str encoding process string
     * @param sBuild stringBuilder
     */
  private void encodeMessage(char charofMessage, BinaryTree < HuffData > currentTree , String str , StringBuilder sBuild ){
        if(currentTree == null){
            return;
        }
        if(currentTree.root.left == null && currentTree.root.right == null) {
            if (currentTree.root.data.symbol == charofMessage)
                sBuild.append(str);

        }
      encodeMessage(charofMessage,currentTree.getLeftSubtree(),str+"0",sBuild);
      encodeMessage(charofMessage,currentTree.getRightSubtree(),str+"1",sBuild);
  }



}
