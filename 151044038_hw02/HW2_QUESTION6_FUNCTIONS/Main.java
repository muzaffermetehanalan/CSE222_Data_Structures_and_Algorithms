import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
/**
 * Bu class HW1'de kullanilan belirli fonksiyonlarin 
 * ArrayList , Array  ve LinkedListte implement edilerek aralarindaki performans
 * farkini incelemek amaciyla yapilmistir.
 * Her tip icin ayri ayri fill ve remove fonksiyonlari bulunmaktadir.
 * 
 */
public class Main {
	private static int arraySize = 10;
	private static Books booksArray[] = new Books[arraySize];
	private static ArrayList<Books> booksArrayList = new ArrayList();
	private static LinkedList<Books> booksLinkedList = new LinkedList<Books>();
	/**
	 * Main methodudur , timer kullanarak ArraList, Array
	 * ve LinkedList tiplerinin ne kadar sürede kitap ekleme ve cikarma
	 * islemleri yaptiklarini hesaplar ve ekrana basar.
	 */
	public static void main(String[]args) {
		{
		long startTime = System.nanoTime();
			fillArray(arraySize);
			for(int i =0 ;i < arraySize;i++){
				removeGivenBookFromArray(i);
			}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("That took for Array     =  " + duration + " milliseconds");
		}
		arraySize=1000;
		{
		long startTime = System.nanoTime();
			fillArrayList(arraySize);
			for(int i =0 ;i < arraySize;i++){
				removeGivenBookFromList(i);
			}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("That took for ArrayList =  " + duration + " milliseconds");
		}

		{
		long startTime = System.nanoTime();
			fillLinkedList(arraySize);
			for(int i =0 ;i < arraySize;i++){
				removeGivenBookFromList(i);
			}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("That took for LinkedList = " + duration + " milliseconds");
		}
	}
	/**
     * @param size Arrayin alabilecegi size
	 * Fonksiyon arrayi doldurur.
	 */
	public static void  fillArray(int size){

		for(int i=0;i<size;i++){
			booksArray[i]=new Books(i,"Book Name");
		}
	}
	/**
     * @param size ArrayList alabilecegi size
	 * Fonksiyon arraylisti doldurur.
	 */
	public static void fillArrayList(int size){
		for(int i=0;i<size;i++){
			booksArrayList.add(new Books(i,"Book Name"));
		}	
	}
	/**
     * @param id ArrayListten silinecek olan id li kitap
	 * Fonksiyon arrayListten verilen idli kitabi siler
	 */
	public static void removeGivenBookFromList(int id){
		for(int i=0;i<booksArrayList.size();i++){
			if(booksArrayList.get(i).getID() == id ){
				booksArrayList.remove(i);
			}
		}
	}
	/**
     * @param id Array'den silinecek olan id li kitap
	 * Fonksiyon array'den verilen idli kitabi siler
	 */
	public static void removeGivenBookFromArray(int id){
		int foundIndex = -1;

		for(int i=0;i<arraySize;i++){
			if(booksArray[i].getID() == id){
				foundIndex = i;
			}
		}
			
		Books tempBooksArray[] = new Books[arraySize-1];
		arraySize--;
		for(int i= 0,j =0;j<arraySize;i++){
			if(i!=foundIndex){
				tempBooksArray[j]=new Books(booksArray[i].getID(),booksArray[i].getBookName());
				j++;
			}
		}
		booksArray = new Books[arraySize];
		for(int i=0;i<arraySize;i++){
			booksArray[i] = new Books(tempBooksArray[i].getID(),tempBooksArray[i].getBookName());
		}		
	}

	public static void fillLinkedList(int size){
		for(int i=0;i<size;i++){
			booksLinkedList.add(new Books(i,"Book Name"));
		}	
	}

	public static void removeGivenBookFromLinked(int id){
		for(int i=0;i<booksLinkedList.size();i++){
			if(booksLinkedList.get(i).getID() == id ){
				booksLinkedList.remove(i);
			}
		}	
	}
}
