package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers_05 {
    public static void main(String[] args) {


        String inputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output-5.txt";


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))){

            String line = reader.readLine();
            int count = 1;
            while (line != null){

                writer.write(String.format("%d. %s%n", count, line));

                line = reader.readLine();
                count++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
