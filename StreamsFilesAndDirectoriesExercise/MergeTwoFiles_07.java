package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) {

        String path1 = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output-7.txt";


        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))){

           List<String> first =  Files.readAllLines(Paths.get(path1));
           List<String> second =  Files.readAllLines(Paths.get(path2));

            for (String e : first) {
                writer.write(e + System.lineSeparator());
            }

            for (String e : second) {
                writer.write(e + System.lineSeparator());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
