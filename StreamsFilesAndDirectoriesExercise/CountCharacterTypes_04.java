package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class CountCharacterTypes_04 {
    public static void main(String[] args) {


        String path = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output-4.txt";

        Set<Character> vowels = Set.of('a', 'u', 'e', 'o', 'i');
        Set<Character> pun = Set.of(',', '.', '?', '!');

        int countVowels = 0;
        int countPun = 0;
        int countOthers = 0;


        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))){
            List<String> data = Files.readAllLines(Paths.get(path));

            for (String line : data) {
                for (int i = 0; i < line.length(); i++) {
                    char currentSymbol = line.charAt(i);

                    if (currentSymbol != ' '){
                        if (vowels.contains(currentSymbol)){
                            countVowels++;
                        }else if (pun.contains(currentSymbol)){
                            countPun++;
                        }else {
                            countOthers++;
                        }
                    }

                }
            }
            writer.write(String.format("Vowels: %d%n", countVowels));
            writer.write(String.format("Other symbols: %d%n", countOthers));
            writer.write(String.format("Punctuation: %d%n", countPun));

            //Files.writeString(Paths.get(outputPath), String.format("Vowels: %d%n", countVowels));
            //Files.writeString(Paths.get(outputPath), String.format("Other symbols: %d%n", countOthers));
            //Files.writeString(Paths.get(outputPath), String.format("Punctuation: %d", countPun));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
