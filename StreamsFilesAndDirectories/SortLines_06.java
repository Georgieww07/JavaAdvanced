package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {


        String inputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";


        List<String> inputData = Files.readAllLines(Paths.get(inputPath));
        Collections.sort(inputData);
        Files.write(Paths.get(outputPath), inputData);
    }
}
