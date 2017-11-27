import java.io.*;
import java.util.*;
/**
 * Bu class Library i interface'ini implement eder
 * User bilgi olarak id,name,surname ve passWord bulundurur
 * Sisteme User olarak giris yaptirir, user menusunu kullandirir
 * Kutuphane sistemine giris yapılabilir, kitap alinabilir
 * Alinan kitaplar geri iade edilebilir 
 */ 
public class Users implements Library {
	private int id;
	private String name;
	private String surname;
	private String passWord;
	/**
	 * User constructor'i id,name,surname ve password
	 * atamasini yapar
	 * @param id Userin sayisal kod bilgisini tutar
	 * @param name Userin isim bilgisini tutar
	 * @param surname Userin soyad bilgisini tutar
	 * @param passWord Userin sifre bilgisini tutar
	 */
	public Users(int id , String name , String surname , String passWord){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.passWord=passWord;
	}
	/**
	 * Empty Constructor
	 * Herhangi bir atama yapilmaz
	 */
	public Users(){

	}
	/**
	 * Bu fonksiyon Userin ID bilgisinin atamasini yapar
	 * Herhangi bir sey return etmez
	 * @param id Kisinin ID bilgisini tutar
	 */
	public void setID(int id){
		this.id = id;
	}
	/**
	 * Bu fonksiyon Userin name bilgisinin atamasini yapar
	 * Herhangi bir sey return etmez
	 * @param name Kisinin name bilgisini tutar
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Bu fonksiyon Userin surname bilgisinin atamasini yapar
	 * Herhangi bir sey return etmez
	 * @param surname Kisinin surname bilgisini tutar
	 */
	public void setSurname(String surname){
		this.surname = surname;
	}
	/**
	 * Bu fonksiyon Userin password bilgisinin atamasini yapar
	 * Herhangi bir sey return etmez
	 * @param passWord Kisinin passWord bilgisini tutar
	 */
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	/**
	 * Bu fonksiyon Userin isim bilgisini dondurur
	 * @return name Userin isim bilgisi dondurulur
	 */
	public String getName(){
		return name;
	}
	/**
	 * Bu fonksiyon Userin soyadi bilgisini dondurur
	 * @return surname Userin soyadi bilgisi dondurulur
	 */
	public String getSurname(){
		return surname;
	}
	/**
	 * Bu fonksiyon Userin sifre bilgisini dondurur
	 * @return passWord Userin sifre bilgisi dondurulur
	 */
	public String getPassWord(){
		return passWord;
	}
	/**
	 * Bu fonksiyon Userin ID bilgisini dondurur
	 * @return id Userin ID bilgisi dondurulur
	 */
	public int getID(){
		return id;
	}
	/**
	 * Bu fonksiyon User'in sisteme giris menusudur
	 * User'dan ID ve sifresini ister
	 * Eger sisteme giris yapılabilirse , kitap almak icin 1
	 * Kitap iadesi icin 2 ve ana menuye donmek icin 3 secenekleri sunulur
	 * Kitap alinmak istendiginde alinabilecek kitaplar ekrana bastirilir
	 * Herhangi bir sey return etmez
	 */
	@Override
	public void loginToMenu(){
		Staff staff = new Staff();
		staff.fillUsersList();
		staff.fillBooksList();
		int id;
		int check = 1;
		String passWord;
		Scanner scanner = new Scanner(System.in);
		System.out.println("User giris ekranina hosgeldiniz!");
		System.out.println("Sisteme giris yapmak icin sirayla 'ID' nizi ve Sifrenizi giriniz.");
		System.out.print("ID:");
		id = scanner.nextInt();
		passWord = scanner.nextLine();
		System.out.print("\nSifre:");
		passWord = scanner.next();
		if( isUserExist(id,passWord)){
			while(check != 3){
				System.out.println("1)Sistemden kitap almak icin '1' ");
				System.out.println("2)Aldiginiz kitabi iade etmek icin '2' ");
				System.out.println("3)Ana menuye donmek icin '3' tuslayiniz");
				check = scanner.nextInt();
				if(check == 1){
					displayBooks();
					borrowBook();
				}
				else if(check == 2 ){
					addBook();
				}
			}
		}
	}
	/**
	 * Bu fonksiyon sisteme User girisi yapilmasi esnasinda
	 * girilen bilgilerin sistemde gecerli olup olmadigini kontrol eder
	 * Eger ID bulunamazsa sistemde kayitli olmadigi soylenir.Sifre yanlis
	 * Girilirse sifrenin yanlis girildigi soylenir.
	 * @return boolean Girilen bilgilerin bulunup bulunmadigina gore true veya false dondurur
	 * @param id Userin sayısal kod bilgisini tutar
	 * @param passWord Userin sifre bilgisini tutar
	 */
	public boolean isUserExist(int id, String passWord){
		Staff staff = new Staff();
		staff.fillUsersList();
		for(Users user : staff.getUsersDataBase()){
			if(user.getID() == id)
			{
				if((user.getPassWord().equals(passWord))){
					System.out.println(user.getName() + " " + user.getSurname() +" sisteme hosgeldiniz!");
					return true;
				}
				System.out.println("Sifrenizi yanlis girdiniz");
				return false;
			}
		}
		System.out.println("Bu ID sisteme kayitli degildir");
		return false;
	}
	/**
         * Bu fonksiyon User' a sistemdeki kitaplari gormesini saglar
	 * User Menuden kitap almak istedigi zaman kitaplar ID ve isimleri ile
	 * gosterilir.
	 * Herhangi bir sey return etmez
	 */
	public void displayBooks() {
		Staff staff = new Staff();
		staff.fillBooksList();
		System.out.println("Alabileceginiz kitaplarin listesi :");

		for(Books book : staff.getBooksDataBase()){
			System.out.println(book.getID()+ "  " + book.getBookName() );
		}
	}
	/**
	 * Bu fonksiyon User'in kutuphane sisteminden kitap
	 * almasini saglar , alinmasi istenilen kitabin id'si sorulur ve teslim edilir.
	 * Kitap once Listeden cikarilir,daha sonra csv dosyasina son hali yazilir
	 * Herhangi bir sey return etmez 
	 */
	public void borrowBook(){
		Staff staff = new Staff();
		int id;
		System.out.println("Lutfen almak istediginiz kitabin ID 'sini giriniz");
		System.out.print("ID :");
		Scanner scanner = new Scanner(System.in);
		id = scanner.nextInt();
		staff.removeBook(id);
	}
	/**
	 * Bu fonksiyon User'in aldigi kitaplari sisteme iade
	 * etmesini saglar.Iade etmesini istedigi kitabin ismi
	 * ve id'si alinir. Daha sonra kitap listeye eklenir.
	 * Listenin son haliyle csv dosyasina yazilir
         * Herhangi bir sey return etmez
	 */
	@Override
	public void addBook(){
		Staff staff = new Staff();
		staff.fillBooksList();
		staff.addBook();
		staff.uploadBooksToFile();
	}
}
