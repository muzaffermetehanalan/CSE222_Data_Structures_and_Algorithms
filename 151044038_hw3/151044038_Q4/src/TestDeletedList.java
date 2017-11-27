/**
 * Created by Metehan on 11.03.2017.
 */
public class TestDeletedList {
    public static void main(String args[]) {

        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println("List 100 integer ile doluyor :");
        System.out.println(list.toString());
        for (int i = 50; i < 100; i++) {
            list.removeLast();
        }
        System.out.println("Listenin son 50 elemanı silindi , yedeklendi :");
        System.out.println(list.toString());
        System.out.println("Listeden silinen ve yedeklenen sayilar :");
        System.out.println(list.deletedToString());
        System.out.println("Listeye 100 eleman ekleniyor , yedeklenen sayilar oncelikli olarak listeye ekleniyor");
        for(int i= 50;i<150;i++){
            list.add(i);
        }
        System.out.println(list.toString());
        System.out.println(list.deletedToString());

    }
}
