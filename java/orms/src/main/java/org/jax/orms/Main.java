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

            File data = new File("./orms/file");
            System.out.println(data.getAbsolutePath());
            File[] files = data.listFiles();

            if (files != null) {
                System.out.println("abc" + files.length);
            } else {
                System.out.println("asasasas========");
            }

            File file = new File("./orms/file/demo.xml");

            System.out.println(file.exists());

            File encryptedFile = new File("./orms/file/encryptFile.encrypted");
            System.out.println(encryptedFile.exists());
            File decryptedFile = new File("./orms/file/decryptFile.decrypted");

            EncryptUtils.encryptFile(key, ivParameterSpec, file, encryptedFile);
            EncryptUtils.decryptFile(key, ivParameterSpec, encryptedFile, decryptedFile);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
