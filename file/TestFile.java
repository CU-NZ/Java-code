package io.file;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\64576\\Desktop\\TestFile.java");
        if(file.exists()){
            file.delete();
        }else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
