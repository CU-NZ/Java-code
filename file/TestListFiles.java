package io.file;

import java.io.File;

public class TestListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\64576\\Desktop\\javaIO");
        if(file.exists() &&file.isDirectory()){
            File[] result = file.listFiles();
            for(File file1 : result){
                System.out.println(file1);
            }
        }
    }
}
