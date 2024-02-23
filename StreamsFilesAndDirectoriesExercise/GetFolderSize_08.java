package StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.nio.file.Paths;

public class GetFolderSize_08 {
    public static void main(String[] args) {


        String path = "C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);

        int sumLengths = 0;

        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files != null){
                for (File f : files) {
                    sumLengths += f.length();
                }
            }

        }

        System.out.println("Folder size: " + sumLengths);
    }
}
