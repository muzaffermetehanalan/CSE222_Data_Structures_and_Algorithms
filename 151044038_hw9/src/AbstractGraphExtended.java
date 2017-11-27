import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
/**
 * Created by Metehan on 16.05.2017.
 */
public class AbstractGraphExtended extends AbstractGraph {
    @Override
    public void insert(Edge edge) {
    }
    @Override
    public boolean isEdge(int source, int dest) {
        return false;
    }
    @Override
    public Edge getEdge(int source, int dest) {
        return null;
    }
    @Override
    public Iterator<Edge> edgeIterator(int source) {

        return null;
    }

    /**
     *  Constructor
     * @param numV vertex counter
     * @param directed is directed or not
     */
    public AbstractGraphExtended(int numV, boolean directed) {
        super(numV, directed);
    }

    /**
     * This function adds new Edges with using edgeLimit
     * @param edgeLimit Limit for adding edge
     * @return Added edge count
     */
    public int addRandomEdgesToGraph (int edgeLimit){
        Random random = new Random();
        RandomRange randomRange = new RandomRange();
        int randLimit = randomRange.showRandomInteger(1,edgeLimit-1,random);

        for(int i=0;i<randLimit;i++){
            int src = randomRange.showRandomInteger(0,getNumV()-1,random);
            int dst = randomRange.showRandomInteger(0,getNumV()-1,random);
            Edge tmpEdge = new Edge(src,dst);
            insert(tmpEdge);
        }
        return randLimit;
    }

    /**
     * This function is BFS
     * @param start A vertex for starting point
     * @return
     */
    public int [] breadthFirstSearch (int start){
        boolean visited[] = new boolean[getNumV()];
        int [] arr = new int[getNumV()];
        int tmp , i = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
        while(queue.size()!=0){
            tmp = queue.poll();
            arr[i] = tmp;
            i++;
            Iterator it = edgeIterator(tmp);
            while(it.hasNext()){
                Edge tmpEdge =(Edge) it.next();
                int nextVal = tmpEdge.getDest();
                if(visited[nextVal]!=true){
                    visited[nextVal] = true;
                    queue.add(nextVal);
                }

            }
        }
        return arr;

    }

    /**
     * this function returns connected component graphs
     * @return this function returns connected component graphs
     */
    public Graph[] getConnectedComponentUndirectedGraph (){
        boolean flag = true;
        ArrayList<int[]> bstList = new ArrayList<>();
        for(int i = 0;i<getNumV() ; i++){
            bstList.add(breadthFirstSearch(i));
            Arrays.sort(bstList.get(i));
        }

        for(int i = 0; i<bstList.size();i++) {
            for(int k=i+1 ; k<bstList.size();k++) {
                if (bstList.get(i).length == bstList.get(k).length) {
                    for (int j = 0; j < bstList.get(i).length; j++) {
                        if (bstList.get(i)[j] != bstList.get(k)[j]) {
                            flag = false;
                        }

                    }
                } else {
                    flag = false;
                }

                if (flag == true) {

                    bstList.remove(k);
                    i=i-1;
                    k=bstList.size();
                }
            }
        }
        Graph tmp;
        Graph graphArr [] = new AbstractGraphExtended[bstList.size()];
        for(int i=0;i<bstList.size();i++){
            tmp = new AbstractGraphExtended(bstList.get(i).length,isDirected());
            for(int k=0;k<(bstList.get(i).length)-1;k++){
                for(int j=k+1;j<(bstList.get(i).length)-1;j++){
                    if(isEdge( bstList.get(i)[k],bstList.get(i)[j])){
                        Edge tmpEdge = new Edge( bstList.get(i)[k],bstList.get(i)[j]);
                        insert(tmpEdge);
                    }
                }
            }

            graphArr[i] = tmp;
        }
        return graphArr;
    }

    /**
     * This function checks whether graph is bipartite or not
     * @return true or false
     */
    public boolean isBipartiteUndirectedGraph (){
        Boolean [] visited = new Boolean[getNumV()];
        Integer [] levels = new Integer[getNumV()];
        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }
        visited[0] = true;
        levels[0] = 0;
        Queue<Integer> que = new LinkedList();
        que.add(0);
        while(!que.isEmpty()) {
            int temp = que.poll();
            Iterator it = edgeIterator(temp);
            while (it.hasNext()) {
                Edge tmpEdge = (Edge) it.next();
                int nextVal = tmpEdge.getDest();
                if (!visited[nextVal]) {
                    visited[nextVal] = true;
                    levels[nextVal] = levels[temp] + 1;
                    que.add(nextVal);
                } else if (levels[temp] == levels[nextVal]) {
                    return false;
                }

            }
        }
        return true;

    }

    /**
     * This function write graph to file
     * @param fileName a file to write graph
     */
    public void writeGraphToFile (String fileName){
        try{
            PrintWriter writer = new PrintWriter(fileName);
            writer.println(getNumV());
            for(int i = 0 ; i<getNumV() ; i ++){
                Iterator it = edgeIterator(i);
                while(it.hasNext()){
                    Edge tmpEdge = (Edge) it.next();
                    writer.println(tmpEdge.getSource() + " " + tmpEdge.getDest());
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
