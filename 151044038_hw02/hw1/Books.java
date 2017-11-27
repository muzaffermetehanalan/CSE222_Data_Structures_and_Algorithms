import java.io.*;
import java.util.*;
/**
 * Bu class kutuphane sistemindeki kitaplarin sistemde tutulmasini saglar.
 * Kitabin ID'si ve ismi icin setter ve getterlara sahiptir.
 *
 */
public class Books {
	private int id;
	private String bookName;

	/**
	 * Verilen id ve bookname in atamasini yapar
	 * @param id  kitabin sayisal olarak kodunu tasir
	 * @param bookName kitabin isim bilgisini tasir
	 */
	public Books(int id , String bookName){
		this.id = id;
		this.bookName = bookName;	
	}
	/**
	 * Bu fonksiyon verilen id nin objeye atamasini yapar
	 * @param id kitabin sayisal olarak kodunu tasir
	 * No return value 
	 */
	public void setID(int id){
		this.id = id;
	}
	/**
	 * Bu fonksiyon verilen ismin objeye atamasini yapar
	 * @param bookName kitabin isim bilgisini tasir
	 * No return value 
	 */
	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	/**
	 * Kitabin ID'sini return eder
	 * @return id Kitabin sayisal kodu dondurulur 
	 */
	public int getID(){
		return id;
	}
	/**
	 * Kitabin ismini return eder
	 * @return bookName Kitabin ismi dondurulur
	 */
	public String getBookName(){
		return bookName;
	}

}