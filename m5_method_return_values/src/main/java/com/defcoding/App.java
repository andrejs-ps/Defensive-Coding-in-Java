package com.defcoding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class App {


    public static void main(String[] args){

        Path path = Paths.get("src/main/file.txt"); // doesn't exist
        write(path, "Text");

        // retrieving the file later will fail
    }

    private static void write(Path path, String text) {
        try {
            Files.write(path, text.getBytes());
        } catch (IOException e) {
            // swallowing up the exception will lead to a failure later
        }
    }
}
