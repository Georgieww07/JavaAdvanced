package StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles_07 {
    public static void main(String[] args) {



        File f = new File("C:\\Users\\gogeo\\Desktop\\Java\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (f.exists()){
            if (f.isDirectory()){
                File[] files = f.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()){
                        System.out.printf("%s: [%d]\n", file.getName(), file.length());
                    }

                }


            }
        }
    }
}
