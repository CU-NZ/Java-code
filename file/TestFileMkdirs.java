package io.file;

import java.io.File;
import java.io.IOException;


public class TestFileMkdirs {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\64576\\Desktop");
        listAllFile(file);
    }
    public static void listAllFile(File file){
        if(file.isDirectory()){
            File[] result = file.listFiles();
            if (result != null){
                for (File file1 : result){
                    listAllFile(file1);
                }
            }
        }else{
            System.out.println(file);
        }
    }

}
