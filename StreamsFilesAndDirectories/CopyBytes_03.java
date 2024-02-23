package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)){

            int oneByte = fileInputStream.read();
            while (oneByte >= 0){
                if (oneByte == 10 || oneByte == 32){
                    fileOutputStream.write(oneByte);
                }else {
                    String data = String.valueOf(oneByte);

                    for (char letter : data.toCharArray()) {
                        fileOutputStream.write(letter);

                    }
                }

                oneByte = fileInputStream.read();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
