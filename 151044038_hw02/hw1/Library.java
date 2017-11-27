import java.io.*;
import java.util.*;
/**
 * Bu interface Kutuphane sistemini yoneten
 * Login fonksiyonunu bulundurur.
 * Staff ve User classlari ile is a iliskisi icerir
 */
public interface Library {
	/**
	 * Abstract Methods
	 */
	public void loginToMenu();
	public void addBook();
}
