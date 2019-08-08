package io.file;

import java.io.*;

class CopyFileUtil{
    private CopyFileUtil(){
    }

    public static boolean fileExists(String path){
        return new File(path).exists();
    }

    public static void createParentsDir(String path){
        File file = new File(path);
        if (! file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }

    public static boolean copyFile(String sourcePath,String destpath){
        File inFile = new File(sourcePath);
        File outFile = new File(destpath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileoutputStream = null;
        try {
            fileInputStream = new FileInputStream(inFile);
            fileoutputStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally {

            try {
                fileInputStream.close();
                fileoutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
        }
        private static void CopyFileHandle(InputStream inputStream,OutputStream outputStream) throws IOException{
        long start = System.currentTimeMillis();
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(data)) != -1){
            outputStream.write(data,0,len);
        }
        long end = System.currentTimeMillis();
            System.out.println("拷贝文件所花费的时间："+(end - start));
        }
}

public class CopyFile{
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("非法操作，命令为：源文件路径 目标文件路径");
            return;
        }
        String sourcePath = args[0];
        String destPath = args[1];
        if (CopyFileUtil.fileExists(sourcePath)){
            CopyFileUtil.createParentsDir(sourcePath);
            System.out.println(CopyFileUtil.copyFile(sourcePath,destPath)?"文件拷贝成功":"文件拷贝失败");
        }else{
            System.out.println("源文件不存在，无法拷贝");
        }
    }
}
