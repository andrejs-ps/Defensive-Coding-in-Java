package com.defcoding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Java7 {


    public static void main(String[] args){

        try (FileOutputStream outStream = new FileOutputStream("file.text");
             ObjectOutputStream stream = new ObjectOutputStream(outStream)) {
            // write
        }catch(IOException e) {
            // handle e properly
        }
    }
}







