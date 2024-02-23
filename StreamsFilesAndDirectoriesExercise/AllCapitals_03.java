package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals_03 {
    public static void main(String[] args) {


        String path = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))){
            String line = reader.readLine();

            while (line != null){
                line = line.toUpperCase();
                writer.write(line);    // writer.write(line + System.lineSeparator())
                writer.newLine();


                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
