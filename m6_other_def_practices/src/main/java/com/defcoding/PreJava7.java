package com.defcoding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PreJava7 {

    public static void main(String[] args) {

    FileOutputStream outStream = null;
    try {
        outStream = new FileOutputStream("file.txt");
        ObjectOutputStream stream = new ObjectOutputStream(outStream);
            // write
            stream.close();
        } catch (IOException e) {
            // handle e properly
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception e) {
                    // handle e properly
                }
            }
        }
    }
}
