package io.file;


import java.io.File;
        import java.io.IOException;
        import java.util.Date;

public class TestIoFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\64576\\Desktop\\TestFile.java");
        if(file.exists() && file.isFile()){
            System.out.println("文件大小："+file.length());
            System.out.println("最后一次修改日期："+ new Date(file.lastModified()));
        }
    }
}
