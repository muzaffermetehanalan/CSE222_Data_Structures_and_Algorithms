/**
 * Created by Metehan on 6.04.2017.
 */

import java.io.*;
import java.util.*;

public class TestFamilyTree {
    public static void main(String args[]){
        try {
            BufferedReader fileReader = null;
            fileReader = new BufferedReader(new FileReader("family.txt"));
            String line="";
            final String COMMA_DELIMITER = ",";
            line =fileReader.readLine();
            FamilyTree<String> family = new FamilyTree<String>(line.trim());
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                family.insert(tokens[0].trim(),tokens[1].trim(),tokens[2].trim());
            }
            family.preOrderTravers();
            fileReader.close();

        }catch(MyException|IOException e){
            System.out.println("Exception found"+ e);
        }
    }
}
