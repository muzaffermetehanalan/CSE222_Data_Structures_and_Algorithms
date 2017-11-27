/**
 * Created by Metehan on 5.04.2017.
 */
import java.util.*;
public class BinarySearchTree<E> extends BinaryTree<E> {
    Iterator <E>  levelOrderIterator(){
        return new LevelIterator<E>(preOrderList);
    }
    private class LevelIterator<E> implements Iterator<E>{
        ArrayList <E> levelOrderItList = null;
        /**
         * LevelIterator constructor.
         * Verilen listeyi iteratorun listesine atamasini yapar.
         * @param givenList Travers edilmis liste
         */
        private LevelIterator(ArrayList<E> givenList){
            levelOrderItList = new ArrayList(givenList);
        }
        /**
         * Listede eleman kalip kalmamasina bakar
         * @return eger eleman varsa true , yoksa false return eder
         */
        public boolean hasNext() {
            if(levelOrderItList.size()==0){
                return false;
            }
            return true;
        }
        /**
         * Iterator gosterdigi node u return eder , ve bir sonraki node u gosterir
         * @return temp Iteratorun gosterdigi yerin datasi
         */
        public E next() {
            E temp = levelOrderItList.get(0);
            levelOrderItList.remove(0);
            return temp;
        }
    }

    /**
     * Bu fonksiyon verilen agacin level order seklinde
     * ekrana basar, iterator kullanarak bunu yapar.
     */
    public void levelOrderTravers(){
        preOrderList = new ArrayList<E>();
        for(int i = 1 ; i <= getDepth() ; i++){
            levelOrderTravers(root,i);
        }
        try {
            Iterator<E> traverIter = iterator();
            while (traverIter.hasNext()) {
                System.out.print(traverIter.next());
                if (traverIter.hasNext()) {
                    System.out.print(" , ");
                }
                else{
                    System.out.println();
                }
            }
        }catch( Exception e){
            System.out.println("Exception found = "+ e);
        }

    }

    /**
     * Bu fonksiyon verilen agacin rootundan baslayarak
     * agaci level order olarak recursion travers eder.
     * @param root Verilen agacin root'u
     * @param depth Verilen agacin derinligi
     */
    public void levelOrderTravers(Node <E> root, int depth){
        if(root == null){
            return ;
        }
        if(depth == 1){
            preOrderList.add(root.data);
        }
        else if(depth>1){
            levelOrderTravers(root.left,depth-1);
            levelOrderTravers(root.right,depth-1);
        }

    }
}
