/**
 * Created by Metehan on 18.04.2017.
 */
import java.util.*;
import java.io.*;
public class TestHuffmanTree {
    public static void main(String args[]){
        HuffmanTree.HuffData [] treeData ;
        ArrayList <HuffmanTree.HuffData> dataList = new ArrayList<>();
        HuffmanTree huffTree = new HuffmanTree();
        ArrayList <Character> charList = new ArrayList<>();
        StringBuilder tester = new StringBuilder();
        File file = new File("freq.txt");
        try {
            String strType;
            double freq;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                strType = scanner.next();
                freq = scanner.nextDouble();
                charList.add(strType.charAt(0));
                HuffmanTree.HuffData huffObj = new HuffmanTree.HuffData(freq,strType.charAt(0));
                dataList.add(huffObj);
                if(scanner.hasNextLine()){
                    scanner.nextLine();
                }
            }
            treeData= new HuffmanTree.HuffData[dataList.size()];
            for(int i = 0; i < dataList.size() ; i ++){
                treeData[i]= dataList.get(i);
            }
            scanner.close();
            huffTree.buildTree(treeData);
            for(int i = 0; i < charList.size() ; i++){
                System.out.println("Decoding " + huffTree.encode(charList.get(i).toString()) + "  " + huffTree.decode(huffTree.encode(charList.get(i).toString())));
            }

            for(int i = 0; i<charList.size() ; i++){
                tester.append(charList.get(i).toString());
                System.out.println("Encoding " + charList.get(i).toString() + "  " + huffTree.encode(charList.get(i).toString()));
            }
            System.out.print("Encoding ");
            for(int i = 0; i<charList.size(); i++){
                System.out.print(charList.get(i).toString());
            }
            System.out.print("  " + huffTree.encode(tester.toString()));
        } catch(Exception e){
            System.out.println("Exception found = "+ e);
        }

    }
}
