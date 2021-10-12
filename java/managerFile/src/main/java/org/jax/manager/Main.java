package org.jax.manager;

import org.jax.manager.common.FileUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Manager file");
//        FileUtils.createFileTxt("demo.txt", "demo created file \n new line");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        FileUtils.appendFileTxt("demo.txt", input);
    }
}
