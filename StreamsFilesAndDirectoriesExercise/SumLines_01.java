package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines_01 {
    public static void main(String[] args) {


        String path = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))){
            String line = bufferedReader.readLine();

            while (line != null){
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    char currentLetter = line.charAt(i);
                    sum += currentLetter;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
