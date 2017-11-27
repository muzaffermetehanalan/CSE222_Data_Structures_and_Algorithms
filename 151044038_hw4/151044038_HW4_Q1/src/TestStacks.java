import java.io.*;
import java.util.*;

/**
 * Created by Metehan on 19.03.2017.
 */
public class TestStacks {

    public static void main(String args[]) {
        StackInterface<Object> stackA = new StackA<Object>();
        StackInterface<Object> stackB = new StackB<Object>();
        StackInterface<Object> stackC = new StackC<Object>();
        StackInterface<Object> stackD = new StackD<Object>();
        long duratA=0;
        long duratB=0;
        long duratC=0;
        long duratD=0;
        long StartTime , EndTime;
        final String inputFileName = "test.csv";
        final String outputFileName = "testResult_1.csv";
        BufferedReader csvReader = null;
        FileWriter csvWriter = null;
        final String SEPERATOR = ",";
        final String NEWLINE = "\n";
        int i=0;
        try {
            csvReader = new BufferedReader(new FileReader(inputFileName));
            csvWriter = new FileWriter(outputFileName, false);

            String line = "";

            while ((line = csvReader.readLine()) != null) {

                String[] datas = line.split(SEPERATOR);

                for (String addedStr : datas) {
                    stackC.push(addedStr);
                    stackD.push(addedStr);
                    stackA.push(addedStr);
                    stackB.push(addedStr);
                }

                Integer stackSize = stackA.size();

                csvWriter.append("StackA Size == " + stackSize.toString());
                csvWriter.append(SEPERATOR);
                while(i < stackSize){
                    long startTime = System.nanoTime();
                    if (i == stackSize - 1) {
                        csvWriter.append(stackA.pop().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(stackA.pop().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                    long endTime = System.nanoTime();
                    duratA += endTime - startTime;
                }
                i=0;

                csvWriter.append("StackB Size == " + stackSize.toString());
                csvWriter.append(SEPERATOR);
                while(i < stackSize) {
                    long startTime = System.nanoTime();
                    if (i == stackSize - 1) {
                        csvWriter.append(stackB.pop().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(stackB.pop().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                    long endTime = System.nanoTime();
                    duratB += endTime - startTime;
                }
                i=0;
                csvWriter.append("StackC Size == " + stackSize.toString());
                csvWriter.append(SEPERATOR);
                while(i< stackSize) {
                    long startTime = System.nanoTime();
                    if (i == stackSize - 1) {
                        csvWriter.append(stackC.pop().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(stackC.pop().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                    long endTime = System.nanoTime();
                    duratC += endTime - startTime;
                }
                i=0;
                csvWriter.append("StackD Size == " + stackSize.toString());
                csvWriter.append(SEPERATOR);
                while ( i < stackSize) {
                    long startTime = System.nanoTime();
                    if (i == stackSize - 1) {
                        csvWriter.append(stackD.pop().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(stackD.pop().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                    long endTime = System.nanoTime();
                    duratD += endTime - startTime;
                }
                i=0;
            }
        } catch (Exception E) {
            System.out.println("File not found error");
        } finally {
            try {
                csvWriter.flush();
                csvWriter.close();
                csvReader.close();
            } catch (Exception E) {
                System.out.println("File not closed!");
            }
        }

        System.out.println("That took for stackA = " + duratA );
        System.out.println("That took for stackB = " + duratB );
        System.out.println("That took for stackA = " + duratC );
        System.out.println("That took for stackB = " + duratD );



    }
}