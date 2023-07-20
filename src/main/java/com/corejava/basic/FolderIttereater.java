package com.corejava.basic;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderIttereater {

   public static void printFolder(Path dirPath) throws IOException {
       Files.list(dirPath).forEach(fp-> {
           if(fp.toFile().isDirectory()){
               try {
                   printFolder(fp);
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }else{
               System.out.println(fp.toAbsolutePath());
           }
       });
   }

    public static void main(String[] args) throws IOException {
        String dirPath = "/opt/homebrew/opt/openjdk@11";
        File f = new File(dirPath);
        Path path = Path.of( f.toURI())  ;
        printFolder(path);
    }
}
