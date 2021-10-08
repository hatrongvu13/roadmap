package org.jax.orms;

import org.jax.orms.data.common.EncryptUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            String input = "jaxtony";
            SecretKey key = EncryptUtils.generateKey(128);
            IvParameterSpec ivParameterSpec = EncryptUtils.generateIV();
            String cipherText = EncryptUtils.encrypt(input, key, ivParameterSpec);
            String plainText = EncryptUtils.decrypt(cipherText, key, ivParameterSpec);

            System.out.println(cipherText);
            System.out.println(plainText);

            File data = new File("file");
            System.out.println(data.getAbsolutePath());
            File[] files = data.listFiles();

            if (files != null) {
                System.out.println("Number of file: " + files.length);
            } else {
                System.out.println("File is null");
            }

            File file = new File("file/demo.xml");

            System.out.println(file.exists());

            File encryptedFile = new File("file/encryptFile.encrypted");
            System.out.println(encryptedFile.exists());
            File decryptedFile = new File("file/decryptFile.decrypted");

            EncryptUtils.encryptFile(key, ivParameterSpec, file, encryptedFile);
            EncryptUtils.decryptFile(key, ivParameterSpec, encryptedFile, decryptedFile);

            System.out.println(encryptedFile.getAbsolutePath());
            System.out.println(decryptedFile.getAbsolutePath());

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
