import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by Metehan on 22.03.2017.
 */
public class testQueue<E> {
    public static void main(String args[]) {
        myQueue<Object> myQueueObject = new myQueue<Object>();
        Queue <Object> reverseQue = new LinkedList<>();
        final String inputFileName = "test.csv";
        final String outputFileName = "testResult_2.csv";
        BufferedReader csvReader = null;
        FileWriter csvWriter = null;
        final String SEPERATOR = ",";
        final String NEWLINE = "\n";
        int i = 0;

        try {
            csvReader = new BufferedReader(new FileReader(inputFileName));
            csvWriter = new FileWriter(outputFileName, false);

            String line = "";

            while ((line = csvReader.readLine()) != null) {

                String[] datas = line.split(SEPERATOR);

                for (String addedStr : datas) {
                    reverseQue.add(addedStr);
                    myQueueObject.addLast(addedStr);
                }
                myQueueObject.reverse();
                Integer queueSize = myQueueObject.size;
                while (i < queueSize) {
                    if (i == queueSize - 1) {
                        csvWriter.append(myQueueObject.listIterator(i).next().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(myQueueObject.listIterator(i).next().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                }
                i=0;
                myQueueObject = new myQueue<>();

                myQueueObject.reverseQueue(reverseQue);
                Object [] arr =reverseQue.toArray();
                while(i<queueSize){
                    if (i == queueSize - 1) {
                        csvWriter.append(arr[i].toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(arr[i].toString());
                        csvWriter.append(SEPERATOR);

                    }
                    i++;

                }
                i=0;
                reverseQue = new LinkedList<>();

            }
        }catch (Exception E) {
            System.out.println("File not found error");
    }finally {
        try {
            csvWriter.flush();
            csvWriter.close();
            csvReader.close();
        } catch (Exception E) {
            System.out.println("File not closed!");
        }
    }
    }

}

