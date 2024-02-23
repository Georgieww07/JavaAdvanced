package StreamsFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) {



        String inputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";


        try (FileReader fileReader = new FileReader(inputPath);
             FileWriter fileWriter = new FileWriter(outputPath)){
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    int num = scanner.nextInt();
                    fileWriter.write(num + "\n");

                }
                scanner.next();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
