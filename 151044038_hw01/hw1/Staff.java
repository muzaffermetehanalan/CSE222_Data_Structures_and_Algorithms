import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
/**
 * Bu class Library'i Interface ini implement eder
 * Staff sisteme User ekleyebilir, yani kayit yapabilir
 * Staff sisteme yeni kitaplar ekleyebilir
 * Bu yapilan kayitlar csv dosyalarina yazilir
 */
public class Staff implements Library {
	private FileWriter writerToFile = null;
	private static final int PASSWORD = 12345;
	private static final String BOOKS_HEADER = "ID,Name";
	private static final String USERS_HEADER = "ID,Name,Surname,Password";
	private static final String COMMA = ",";
	private static final String NEWLINE = "\n";
	private static final String BOOKS_CSV_FILE = "books.csv";
	private static final String USERS_CSV_FILE = "users.csv";	
	private ArrayList<Books> booksDataBase = new ArrayList();
	private ArrayList<Users> usersDataBase = new ArrayList();
	/**
	 * @return booksDataBase kitap veri tabanını return eder
	 */
	public ArrayList<Books> getBooksDataBase(){	
		return booksDataBase;
	}
	/**
	 * @return usersDataBase user veri tabanını return eder
	 */
	public ArrayList<Users> getUsersDataBase(){
		return usersDataBase;
	}
	/**
	 * Bu fonksiyon Staff'in sisteme giris menusudur
	 * Staff'in kullanici adi otomatik olarak atanir
	 * Sifre girilmesi istenir, eger sifre dogru girilirse menu acilir
	 * Menude 1 girilirse User ekleme , 2 girilirse Kitap ekleme, 3 girilirse
	 * Ana menuye donulur.Yapilan islemler csv dosyasina yazilir
	 * Herhangi bir sey dondurulmez
	 */
	@Override
	public void loginToMenu(){
		fillBooksList();
		fillUsersList();
		System.out.println("Staff icin login ekranına hosgeldiniz!\n");
		System.out.println("Kullanici adi staff olarak atanmistir , sisteme girmek icin sifreyi giriniz\n");
		System.out.println("Kullanici Adi :staff");
		System.out.print("Sifre :");
		Scanner scan = new Scanner(System.in);
		int passwordController = scan.nextInt();
		if(passwordController == PASSWORD)
		{
			int checkValue = 1;
			System.out.println("Sisteme basariyla giris yaptiniz.");
			while(checkValue != 3){
				if(checkValue != 1 && checkValue != 2 && checkValue != 3){
					System.out.println("Lutfen 1,2 veya 3 girisi yapiniz!");
				}
				System.out.println("1)Yeni User kaydı yapmak icin '1' i tuslayiniz.");
				System.out.println("2)Kitap eklemek icin '2' yi tuslayiniz.");
				System.out.println("3)Ana menuye donmek icin '3' u tuslayiniz.");
				checkValue = scan.nextInt();

				if(checkValue == 2) {
					addBook();
					uploadBooksToFile();
				}

				else if(checkValue == 1){
					addNewUser();
					uploadUsersToFile();
				}
			}

		}

		else {
			System.out.println("Yanlis Parola!");
		}
	}
	/**
	 * Bu fonksiyon sisteme Staff'in kitap eklemesini saglar
	 * Sistem eklemek istenen kitabin id sini ve ismini ister
	 * Kitap once listeye daha sonra da csv dosyasina yazilir
	 * Herhangi bir sey dondurulmez
	 */
	@Override
	public void addBook() { 
		int id;
		String bookName;
		String authorName;
		int check = 1 ;
		Scanner scan = new Scanner(System.in);
		while(check == 1)
		{
			System.out.println("Eklemek istediginiz kitabın sırayla ID'sini , ismini yazınız");
			System.out.print("ID :");
			id = scan.nextInt();
			bookName = scan.nextLine();
			System.out.print("\nKitap Ismi :");
			bookName = scan.nextLine();
			Books book = new Books(id,bookName);
			booksDataBase.add(book);
			System.out.println("Cikis icin 2 , eklemek icin 1 tuslayiniz");
			check = scan.nextInt();
		}
	}
	 /**
	 * Bu fonksiyon sisteme yeni User kaydi yapilmasini saglar
	 * Sistem eklemek istenen Userin ismini soyismini id sini ve ona
	 * Sifre belirlenmesini saglar
	 * User bilgileri once User class listesine daha sonra csv'ye yazilir
	 * Herhangi bir sey dondurulmez
	 */
	public void addNewUser(){
		int check = 1;
		String name;
		String surname;
		String passWord;
		int id;
		Scanner scan = new Scanner(System.in);
		while(check == 1){
			System.out.println("User ekleme ekranina hosgeldiniz.");
			System.out.println("Kayıt etmek istediginiz kullanicinin sırayla Ismini,soyismini ,  id sini ve sifresini giriniz");
			System.out.print("Isim:");
			name = scan.nextLine();
			System.out.print("\nSoyisim:");
			surname = scan.next();
			System.out.print("\nID:");
			id = scan.nextInt();
			System.out.print("\nPassword:");
			passWord = scan.next();
			Users user = new Users(id,name,surname,passWord);
			usersDataBase.add(user);
			System.out.println(name + " " + surname +" " + id + " " + passWord);
			System.out.println("Cikis icin 2 , eklemek icin 1 tuslayiniz");
			check = scan.nextInt();
			name = scan.nextLine();
		}
	}
	/**
	 * Bu fonksiyon sistemdeki kitaplarin guncel olarak
	 * csv dosyasina yuklenilmesini saglar
	 * Herhangi bir sey return etmez
	 * Dosya olusturulamazsa hata mesaji verir
	 */
	public void uploadBooksToFile(){
		try {
				writerToFile = new FileWriter(BOOKS_CSV_FILE);
				writerToFile.append(BOOKS_HEADER.toString());
				writerToFile.append(NEWLINE);
				for(Books book : booksDataBase){
				writerToFile.append(String.valueOf(book.getID()));
				writerToFile.append(COMMA);
				writerToFile.append(book.getBookName());
				writerToFile.append(NEWLINE);
			}

		} catch (Exception e) {
			System.out.println("Dosya olusturulamadi");
			e.printStackTrace();
		} finally {
			try {
				writerToFile.close();
			} catch (Exception e){
				System.out.println("Error!");
				e.printStackTrace();
			}
		}
	}
	/**
	 * Bu fonksiyon sistemdeki Userlarin guncel olarak
	 * csv dosyasina yuklenilmesini saglar
	 * Herhangi bir sey return etmez
	 * Dosya olusturulamazsa hata mesaji verir
	 */
	public void uploadUsersToFile() {
		try {
			writerToFile = new FileWriter(USERS_CSV_FILE);
			writerToFile.append(USERS_HEADER.toString());
			writerToFile.append(NEWLINE);
			for(Users user : usersDataBase){
			writerToFile.append(String.valueOf(user.getID()));
			writerToFile.append(COMMA);
			writerToFile.append(user.getName());
			writerToFile.append(COMMA);
			writerToFile.append(user.getSurname());
			writerToFile.append(COMMA);
			writerToFile.append(user.getPassWord());
			writerToFile.append(NEWLINE);
			}
		}catch (Exception e) {
			System.out.println("Dosya olusturulamadi");
			e.printStackTrace();
		} finally {
			try {
				writerToFile.close();
			} catch (Exception e){
				System.out.println("Error!");
				e.printStackTrace();
			}
		}
	}
	/**
	 * Bu fonksiyon programin guncel olarak kullanilmasini saglar
	 * Yani program kapatip acildiginda database in ayni kaldigi yerden
	 * Devam edilmesini saglar , dosyadan kitaplari okuyup listeye atar
	 * Herhangi bir sey dondurmez 
	 */
	public void fillBooksList() {
		BufferedReader csvReader = null;
		booksDataBase.clear();
		if(new File(BOOKS_CSV_FILE).exists()){
			try {
				String line ="";
				csvReader = new BufferedReader(new FileReader(BOOKS_CSV_FILE));
				csvReader.readLine();
				while ((line = csvReader.readLine()) != null) {
					String[] datas = line.split(COMMA);
					if (datas.length > 0) {
						Books book = new Books(Integer.parseInt(datas[0]),datas[1]);
						booksDataBase.add(book);
					}
				}
			}
			catch(IOException FileNotFoundException){
				System.out.println("Dosya acilamadi");
			}finally {
				try {
					csvReader.close();
				} 
				catch (IOException e) {
					System.out.println("Dosya kapatilma hatasi");
				}
			}
		}
	}
	/**
	 * Bu fonksiyon programin guncel olarak kullanilmasini saglar
	 * Yani program kapatip acildiginda database in ayni kaldigi yerden
	 * Devam edilmesini saglar , dosyadan user bilgilerini okuyup listeye atar
	 * Herhangi bir sey dondurmez 
	 */
	public void fillUsersList() {
		BufferedReader csvReader = null;
		usersDataBase.clear();
		if(new File(USERS_CSV_FILE).exists()){
			try {
				String line ="";
				csvReader = new BufferedReader(new FileReader(USERS_CSV_FILE));
				csvReader.readLine();
				while ((line = csvReader.readLine()) != null) {
					String[] datas = line.split(COMMA);
					if (datas.length > 0) {
						Users user = new Users(Integer.parseInt(datas[0]),datas[1],datas[2],datas[3]);
						usersDataBase.add(user);
					}
				}
			}
			catch(IOException FileNotFoundException){
				System.out.println("Dosya acilamadi");
			}finally {
				try {
					csvReader.close();
				} 
				catch (IOException e) {
					System.out.println("Dosya kapatilma hatasi");
				}
			}
		}
	}
	/**
	 * Bu fonksiyon verilen id deki kitabin sistemden cikarilmasini
	 * Saglar.Once Listeden bu kitabi siler daha sonra csv dosyasina
	 * Guncel halini yazar
	 * Herhangi bir sey dondurmez
	 * @param id
	 */ 
	public void removeBook(int id){
		fillBooksList();
		for(int i=0;i<booksDataBase.size();i++){
			if(booksDataBase.get(i).getID() == id ){
				booksDataBase.remove(i);
			}
		}
		try{
			PrintWriter writer = new PrintWriter(BOOKS_CSV_FILE);
				writer.print("");
				writer.close();
		} catch (IOException FileNotFoundException) {

		}

		uploadBooksToFile();
	}
}
