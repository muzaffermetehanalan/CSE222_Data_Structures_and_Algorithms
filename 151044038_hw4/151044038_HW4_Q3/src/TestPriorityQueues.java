/**
 * Created by Metehan on 21.03.2017.
 */
import java.io.*;
public class TestPriorityQueues {
    public static void main(String args[]) {
        PriorityQueueA<Object> priQueA = new PriorityQueueA<Object>();
        PriorityQueueB<Object> priQueB = new PriorityQueueB<Object>();

        final String inputFileName = "test.csv";
        final String outputFileName = "testResult_3.csv";
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
                    priQueA.add(addedStr);
                    priQueB.add(addedStr);
                }

                Integer queueSize = priQueA.size();
                csvWriter.append("QueueA Size == " + queueSize.toString());
                csvWriter.append(SEPERATOR);

                while (i < queueSize) {
                    if (i == queueSize - 1) {
                        csvWriter.append(priQueA.deleteMin().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(priQueA.deleteMin().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                }

                i = 0;

                csvWriter.append("QueueB Size == " + queueSize.toString());
                csvWriter.append(SEPERATOR);

                while (i < queueSize) {
                    if (i == queueSize - 1) {
                        csvWriter.append(priQueB.deleteMin().toString());
                        csvWriter.append(NEWLINE);
                    } else {
                        csvWriter.append(priQueB.deleteMin().toString());
                        csvWriter.append(SEPERATOR);
                    }
                    i++;
                }

                i = 0;

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

    }
}
