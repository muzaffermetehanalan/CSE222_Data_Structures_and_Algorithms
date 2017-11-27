/**
 * Created by Metehan on 16.05.2017.
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) {
        try {

            File graphData = new File("ExampleIGraphInputOrOutputFile.txt");
            Scanner scnr = new Scanner(graphData);
            ListGraph lgObj = (ListGraph) AbstractGraph.createGraph(scnr, false, "List");
            System.out.println("-------Testing with List class--------");
            System.out.println("Testing addRandomEdgesToGraph : " + lgObj.addRandomEdgesToGraph(9));
            System.out.print("Testing breadthFirstSearch(0) : " );
            int testArr [] = lgObj.breadthFirstSearch(0);
            for(int i= 0 ; i<testArr.length;i++)
                System.out.print(testArr[i] + " " );
            System.out.println();
            System.out.println("Testing isBipartiteUndirectedGraph : " + lgObj.isBipartiteUndirectedGraph());
            System.out.print("Testing getConnectedComponentUndirectedGraph : Graph array size ->  ");
            System.out.println( lgObj.getConnectedComponentUndirectedGraph().length);
            System.out.println("Testing writeGraphToFile ");
            lgObj.writeGraphToFile("lgObjOutputFile.txt");
            scnr.close();
            graphData = new File("ExampleIGraphInputOrOutputFile.txt");
            scnr = new Scanner(graphData);
            System.out.println("-------Testing with Matrix class--------");
            MatrixGraph mxObj = (MatrixGraph) AbstractGraph.createGraph(scnr, false, "Matrix");
            System.out.println("Testing addRandomEdgesToGraph : " + mxObj.addRandomEdgesToGraph(9));
            System.out.print("Testing breadthFirstSearch(0) : " );
            int testArr2 [] = mxObj.breadthFirstSearch(0);
            for(int i= 0 ; i<testArr.length;i++)
                System.out.print(testArr2[i] + " " );
            System.out.println();
            System.out.println("Testing isBipartiteUndirectedGraph : " + mxObj.isBipartiteUndirectedGraph());
            System.out.print("Testing getConnectedComponentUndirectedGraph : Graph array size ->  ");
            System.out.println( mxObj.getConnectedComponentUndirectedGraph().length);
            System.out.println("Testing writeGraphToFile ");
            mxObj.writeGraphToFile("mxObjOutputFile.txt");
        }catch(Exception E){
            E.printStackTrace();
        }
    }
}

