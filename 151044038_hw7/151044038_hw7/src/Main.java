
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;


public class Main
{
    public static void main(String args[]){
        final Boolean q1 = Q1Test();
        final Boolean q2 = Q2Test();
        if (q1 == q2 == Boolean.TRUE) {
            System.out.println("Your tests is done. Make sure that you test all methods of class!! " );
            return;
        }
    }
    public static Boolean Q1Test(){

        NavigableMap<String,String> turkey = new BinaryNavMap<String,String>();
        NavigableMap<String,String> turkeyTemp = new BinaryNavMap<String,String>();
        turkeyTemp = turkey;
        turkey.put("uskudar","istanbul");
        turkey.put("kadıkoy","istanbul");
        turkey.put("cekirge","bursa");
        turkey.put("gebze","kocaeli");
        turkey.put("niksar","tokat");
        turkey.put("kecıoren","ankara");
        turkey.put("aksaray","istanbul");
        turkey.put("foca","izmir");
        turkey.put("manavgat","antalya");
        turkey.put("kahta","adıyaman");
        turkey.put("biga","canakkale");

        System.out.println("The original set odds is " + turkey);
        System.out.println("entrySet() fonksiyonu = " + turkey.entrySet());
        System.out.println("lowerEntry('niksar') = " + turkey.lowerEntry("niksar"));
        System.out.println("lowerKey('niksar') = " + turkey.lowerKey("niksar"));
        System.out.println("floorEntry('manavgat') = " + turkey.floorEntry("manavgat"));
        System.out.println("floorKey('manavgat') = " + turkey.floorKey("manavgat"));
        System.out.println("ceilingEntry('kahta') = " + turkey.ceilingEntry("kahta"));
        System.out.println("ceilingKey('kahta') = " + turkey.ceilingKey("kahta"));
        System.out.println("higherEntry('uskudar') = " + turkey.higherEntry("uskudar"));
        System.out.println("higherKey('uskudar') = " + turkey.higherKey("uskudar"));
        System.out.println("firstEntry() = "+ turkey.firstEntry());
        System.out.println("lastEntry() = " + turkey.lastEntry());
        System.out.println("firstKey() = " + turkey.firstKey());
        System.out.println("lastKey() = " + turkey.lastKey());
        System.out.println("descendingKeySet()= " + turkey.descendingKeySet());
        System.out.println("descendingMap() = "+ turkey.descendingMap());
        System.out.println("navigableKeySet() = " + turkey.navigableKeySet());
        System.out.println("submap(uskudar,true,manavgat,true) =" + turkey.subMap("uskudar",true,"manavgat",true));
        System.out.println("pollFirstEntry() = " + turkeyTemp.pollFirstEntry());
        System.out.println("pollFirstEntry() = " + turkeyTemp.pollFirstEntry());
        System.out.println("pollLastEntry() = " + turkeyTemp.pollLastEntry());
        System.out.println("pollLastEntry() = " + turkeyTemp.pollLastEntry());

        return Boolean.TRUE;

    }

    public static Boolean Q2Test(){

        HashMap<String,String> turkey=new HashTableChaining<String,String>();
        turkey.put("edremit","balikesir");
        turkey.put("edremit","van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul");//we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("kecıoren","ankara");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi","adıyaman");
        turkey.put("golbasi","ankara");
        turkey.put("biga","canakkale");
        /* *test all

            V get(Object key);

            V put(K key, V value);

            V remove(Object key);

            int size();

        * */
        System.out.println("get fonksiyonu 'golbasi'"+ " = " + turkey.get("golbasi"));
        System.out.println("get fonksiyonu 'eregli'"+ " = " + turkey.get("eregli"));

        System.out.println("Size =  " + turkey.size());

        System.out.println("remove fonksiyonu 'ortakoy' icin " + " = " + turkey.remove("ortakoy"));
        System.out.println("Size =  " + turkey.size());
        System.out.println("remove fonksiyonu 'ortakoy' icin " + " = " + turkey.remove("ortakoy"));
        System.out.println("Size =  " + turkey.size());
        System.out.println("remove fonksiyonu 'ortakoy' icin " + " = " + turkey.remove("ortakoy"));
        System.out.println("Size =  " + turkey.size());

        return Boolean.TRUE;
    }


}
