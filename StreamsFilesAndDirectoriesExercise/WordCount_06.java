package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount_06 {
    public static void main(String[] args) {


        String firstPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String secondPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath ="C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output-6.txt";


        try (BufferedReader reader1 = Files.newBufferedReader(Paths.get(firstPath));
             BufferedReader reader2 = Files.newBufferedReader(Paths.get(secondPath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {

            String inputWords = reader1.readLine();
            List<String> words = Arrays.stream(inputWords
                            .split("\\s+"))
                    .collect(Collectors.toList());

            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.putIfAbsent(word, 0);
            }



            String line = reader2.readLine();
            while (line != null){
                String[] currWords = line.split("\\s+");

                for (String curr : currWords) {
                    if (wordCount.containsKey(curr)){
                        wordCount.put(curr, wordCount.get(curr) + 1);
                    }

                }

                line = reader2.readLine();
            }

            wordCount = wordCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                writer.write(String.format("%s - %d%n", key, value));

            }


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}