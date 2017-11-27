import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Metehan on 6.04.2017.
 */
public class FamilyTree<E> extends BinaryTree<E> {
    private int size = 0;
    private int success = 1;

    /**
     * Family'e en ata root un eklemesini yapan constructor
     * @param parent En ata root , en ust parent
     */
    public FamilyTree(E parent){
        super();
        root = new Node<E>(parent);
    }

    /**
     * Bu fonksiyon insert fonksiyonu tarafindan cagirilir
     * recursive olarak family'e ekleme yapar
     * @param root Tree'nin root u , recursive olarak degisir
     * @param addedName Eklenecak olan kisinin ismi
     * @param parentName Eklenecak olan kisinin parent i
     * @param parentNick Eklenecek olan kisinin parentinin nicki
     * @throws MyException Eger mantiksiz bir ekleme yapilirsa
     */
    private void insert(Node <E> root , E addedName , E parentName , E parentNick)throws MyException{
        if(root == null){ }

        else {
            if(root.data.toString().equals(parentName.toString())){
                if(root.nickData != null){
                    Node<E> tempRoot = root;
                    tempRoot = tempRoot.left;
                    if(tempRoot.toString().equals(addedName.toString()))
                        throw new MyException("Bu parent'a tekrardan bu kisiyi ekleyemezsiniz");
                    while(tempRoot.right != null){
                        if(tempRoot.right.toString().equals(addedName.toString()))
                            throw new MyException("Bu parent'a tekrardan bu kisiyi ekleyemezsiniz");

                        tempRoot = tempRoot.right;
                    }

                    tempRoot.right = new Node<E>(addedName);
                    success = 0;
                }
                else{
                    root.nickData = parentNick;
                    root.left = new Node<E>(addedName);
                    success = 0;
                }
            }
            insert(root.left,addedName,parentName,parentNick);
            insert(root.right,addedName,parentName,parentNick);
            if(success == 1){
                throw new MyException("Boyle bir parent bulunamadi");
            }
        }
    }

    /**
     * Bu fonksiyon kullanici tarafindan cagilirak family treeye
     * yeni eleman eklenmesini saglar
     * @param addedName Eklenecak olan kisinin ismi
     * @param parentName Eklenecak olan kisinin parent i
     * @param parentNick Eklenecek olan kisinin parentinin nicki
     * @throws MyException Eger mantiksiz bir ekleme yapilirsa
     */
    public void insert(E addedName , E parentName , E parentNick)throws MyException {
        if(size == 0 && !(parentName.toString().equals(root.data.toString()))){
            throw new MyException("Parent atamasi yapilmadi, ilk once constructor ile parent atanmalidir");
        }
        else{
            insert(root,addedName,parentName,parentNick);
            size++;
            success = 1;
        }

    }

    /**
     * Bu fonksiyon travers edilmesi icin iterator return eder
     * @return FamilyTreeIter
     */
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIter<E>(preOrderList);
    }

    private class FamilyTreeIter <E> implements Iterator<E>{
        ArrayList<E> preOrderFamilyList = null;

        /**
         * FamilyTreeIter constructor.
         * Verilen listeyi iteratorun listesine atamasini yapar.
         * @param givenList Travers edilmis liste
         */
        private  FamilyTreeIter(ArrayList <E> givenList){
            preOrderFamilyList = new ArrayList(givenList);
        }

        /**
         * Listede eleman kalip kalmamasina bakar
         * @return eger eleman varsa true , yoksa false return eder
         */
        @Override
        public boolean hasNext() {
            if(preOrderFamilyList.size()==0){
                return false;
            }
            return true;
        }

        /**
         * Iterator gosterdigi node u return eder , ve bir sonraki node u gosterir
         * @return temp Iteratorun gosterdigi yerin datasi
         */
        @Override
        public E next() {
            E temp = preOrderFamilyList.get(0);
            preOrderFamilyList.remove(0);
            return temp;
        }
    }

    /**
     * Bu fonksiyon verilen family treeyi iterator yardımı ile
     * preOrder olarak travers eder, eger hata olursa NullPointerException
     * yakalanır ve ekrana basilir.
     */
    @Override
    public void preOrderTravers() {
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

    public void levelOrderTravers() {
        preOrderList = new ArrayList<E>();
        for (int i = 1; i <= getDepth(); i++) {
            levelOrderTravers(root, i);
        }
        try {
            Iterator<E> traverIter = iterator();
            while (traverIter.hasNext()) {
                System.out.print(traverIter.next());
                if (traverIter.hasNext()) {
                    System.out.print(" , ");
                } else {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception found = " + e);
        }
    }

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
}
