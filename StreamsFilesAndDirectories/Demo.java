package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {



        Path inPath = Paths.get("C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\DemoInput.txt");
        Path otPath = Paths.get("C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Demo.txt");

        try {
            List<String> inputData = Files.readAllLines(inPath);
            Collections.sort(inputData);
            Files.write(otPath, inputData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
