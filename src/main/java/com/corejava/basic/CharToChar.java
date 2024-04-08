package com.corejava.basic;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Base64;

public class CharToChar {

    private final String data;

    public CharToChar(String data){
        this.data = data;
    }

    private void write() throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        OutputStream fos = new FileOutputStream(new File("oauth_public.key"));
        byte[] result = Base64.getDecoder().decode(data);
        fos.write(result);
        fos.close();
    }

    public static void main(String[] args) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        final CharToChar charToChar = new CharToChar("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAymeMBaPB24Sn4oYxM9THRUd4PrGUPlhl0n7A8ME8zsOTeacQrCu5BTzPbxC26DMgqaqLYdnQfoes+OOD5qvn2UGeJtpvFt2bcqwNSjx/W0LLWovfvb5UPGGTJGM0PZJ91ouIphIYZREYrj+IoT4vosJnzZrSgqCPRqIL1+SsC9PIl9Cw9CaCnas5j2X+5Oh3QbGnBWwLWAxa19JTTfNbkHK4+ktHZBoZT4lrDAbGCejZLv8IsgO7VjOzV9UAFcAGtKRfrGW5Zml5gvIitx+zmG3Z9Ep/t+nzKY42C3+ppDyTGaffukPZPj7CWPEXg8uldToJFCvn7KExUhFmnaSt3QIDAQAB");
        charToChar.write();
/*

        String key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAymeMBaPB24Sn4oYxM9THRUd4PrGUPlhl0n7A8ME8zsOTeacQrCu5BTzPbxC26DMgqaqLYdnQfoes+OOD5qvn2UGeJtpvFt2bcqwNSjx/W0LLWovfvb5UPGGTJGM0PZJ91ouIphIYZREYrj+IoT4vosJnzZrSgqCPRqIL1+SsC9PIl9Cw9CaCnas5j2X+5Oh3QbGnBWwLWAxa19JTTfNbkHK4+ktHZBoZT4lrDAbGCejZLv8IsgO7VjOzV9UAFcAGtKRfrGW5Zml5gvIitx+zmG3Z9Ep/t+nzKY42C3+ppDyTGaffukPZPj7CWPEXg8uldToJFCvn7KExUhFmnaSt3QIDAQAB";
        //String key="SHuexDKW7Kk2aJZgBqajGxGtiqHt1nV1El7liAovUuA";
        byte[] result = Base64.getDecoder().decode(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(result);
        keyFactory.generatePublic(publicKeySpec);
        */

    }
}