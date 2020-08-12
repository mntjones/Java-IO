package com.example.monica;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        System.out.println(path);
        printFile(path);

        System.out.println("\n ----------- \n");

        //Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
        Path filePath = Paths.get(".","files", "SubdirectoryFile.txt");

        printFile(filePath);

        System.out.println("\n ----------- \n");

        filePath = Paths.get("/Users/monica/Google Drive/Java-IO/OutThere.txt");
        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

    }

    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
