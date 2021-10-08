package org.jax.manager.common;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {

    public static void createFileTxt(String file, String content) {
        try {
            File f = new File(file);
            if (f.createNewFile()) {
                System.out.println("Created file "+ f.getAbsolutePath());
            } else {
                System.out.println("Open file "+ f.getAbsolutePath());
            }
            FileWriter fileWriter = new FileWriter(f.getAbsolutePath());
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendFileTxt(String file, String content){
        try {
            File f = new File(file);
            StringBuilder oldContent = new StringBuilder();
            if (f.createNewFile()) {
                System.out.println("Created file " + f.getAbsolutePath());
            }else{
                System.out.println("Open file " + f.getAbsolutePath());
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    oldContent.append(scanner.nextLine());
                    oldContent.append("\n");
                }
            }

            FileWriter fileWriter = new FileWriter(f.getAbsolutePath());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            if (Objects.isNull(oldContent) || oldContent.equals("")) {
                printWriter.println(content);
            } else {
                oldContent.append(content);
                printWriter.println(oldContent);
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
