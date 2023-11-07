import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            Map<String, Integer> wordCounts = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.toLowerCase();

                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Word counts have been written to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}