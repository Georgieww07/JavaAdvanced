package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WriteToFile_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        List<Character> pun = new ArrayList<>(Arrays.asList(',', '.', '!', '?'));

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)){

            int oneByte = fileInputStream.read();
            while (oneByte >= 0){
                char currentByte = (char)oneByte;
                if (!pun.contains(currentByte)){
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
