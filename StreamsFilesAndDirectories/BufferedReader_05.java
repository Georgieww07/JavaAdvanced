package StreamsFilesAndDirectories;
import java.io.*;


public class BufferedReader_05 {
    public static void main(String[] args) {

        String inPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Demo.txt";


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inPath));
        FileWriter fileWriter = new FileWriter(outPath)){
            int count = 1;
            String line = bufferedReader.readLine();
            while (line != null){
                if (count % 3 == 0){
                    fileWriter.write(line + System.lineSeparator());
                }
                count++;
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
