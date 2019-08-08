package io.file;

import java.io.File;
import java.io.IOException;

public class TestCreateFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\64576\\Desktop\\TestCreateFile.java");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
