package org.example.zerothweekworkshop.security;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityUtils {

    public static String generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecureRandom secureRandom = new SecureRandom();
            keyGen.init(256, secureRandom);
            SecretKey secretKey = keyGen.generateKey();
            String result = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println(result);
            return result;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while generating secret key", e);
        }
    }

    public static void main(String[] args) {
        generateSecretKey();
    }
}
