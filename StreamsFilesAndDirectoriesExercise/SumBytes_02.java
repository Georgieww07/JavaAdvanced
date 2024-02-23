package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String path = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = reader.readLine();

            long sum = 0;
            while (line != null){
                for (int i = 0; i < line.length(); i++) {
                    char current = line.charAt(i);
                    sum += current;

                }
                line = reader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
