package com.mycompany.lephuoctoan_2280603296;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cau1 {
    
    public static String splitAndMergeFile(String sourceFile, String destFile, int chunkSize) {
        StringBuilder log = new StringBuilder();
        
        try {
            File f = new File(sourceFile);
            if(!f.exists()) {
                log.append("Khong co file trong folder\n");
                return log.toString();
            }
            
            List<String> partFiles = new ArrayList<>();
            try (FileInputStream fis = new FileInputStream(sourceFile)) {
                byte[] buffer = new byte[chunkSize];
                int bytesRead;
                int partCounter = 1;

                while ((bytesRead = fis.read(buffer)) > 0) {
                    String partName = "part_" + partCounter + ".dat";
                    try (FileOutputStream fos = new FileOutputStream(partName)) {
                        fos.write(buffer, 0, bytesRead);
                    }
                    partFiles.add(partName);
                    partCounter++;
                }
                log.append("Da chia thanh " + (partCounter - 1) + " file nho.\n");
            }
            
            long totalBytes = 0;
            try (FileOutputStream fos = new FileOutputStream(destFile)) {
                for (String part : partFiles) {
                    try (FileInputStream fis = new FileInputStream(part)) {
                        byte[] buffer = new byte[chunkSize];
                        int bytesRead;
                        while ((bytesRead = fis.read(buffer)) > 0) {
                            fos.write(buffer, 0, bytesRead);
                            totalBytes += bytesRead;
                        }
                    }
                }
            }
            log.append("Da ghep file thanh cong: " + destFile + "\n");
            log.append("Log: Tong so byte da xu ly: " + totalBytes + "\n");

        } catch (IOException e) {
            log.append("Loi: " + e.getMessage() + "\n");
        }
        
        return log.toString();
    }
    
    public static void main(String[] args) {
        String sourceFile = "source.jpg"; 
        String destFile = "reconstructed.jpg";
        int chunkSize = 100;
        
        String result = splitAndMergeFile(sourceFile, destFile, chunkSize);
        System.out.println(result);
    }
}