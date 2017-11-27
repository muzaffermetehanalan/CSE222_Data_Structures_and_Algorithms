import java.io.*;
import java.util.*;
/**
 * Bu class kutuphane sistemini yonlendirirerek staff veya
 * User olarak sisteme giris yapilmasini saglar.
 */
public class Menu {
	private Users newUser = new Users();
	private Staff newStaff = new Staff();
	/**
	 * Bu fonksiyon kutuphane sistemini yonetir
	 * 1 tuslayarak Staff , 2 tuslayarak User ve 3 tuslayarak sistemden cikilmasini saglar
	 * User ve Staff classlarini cagirir
	 * Herhangi bir sey return etmez , ekrana hata tespitinde hata bastirir
	 * @throws InputMismatchException Eger menude girilmesi gereken degerler girilmezse
	 * 
	 */
	public void  starterMenu()throws InputMismatchException{
		int checkMenu;
		checkMenu=1;
		while(checkMenu==1){
			try {
				System.out.println("Kutuphane sistemine hosgeldiniz!\n");
				System.out.println("Sisteme Staff olarak giris yapmak icin '1',User olarak giris yapmak icin '2' yi tuslayiniz\n");
				System.out.println("Cikis yapmak icin '3' u tuslayiniz.\n");
				Scanner intReader = new Scanner(System.in);
				int controlInt = intReader.nextInt();
				if(controlInt == 1){
					newStaff.loginToMenu();
				}
				else if(controlInt == 2){
					newUser.loginToMenu();
				}

				else if(controlInt == 3) {
					checkMenu=-1;
				}

			} catch (Exception E){
				System.out.println("Lutfen 1,2 veya 3 girisi yapiniz");
			}
		}
	}
}