package org.jax.manager;

import org.jax.manager.common.FileUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Manager file");
//        FileUtils.createFileTxt("demo.txt", "demo created file \n new line");
        FileUtils.appendFileTxt("demo.txt", "the next text");
    }
}
