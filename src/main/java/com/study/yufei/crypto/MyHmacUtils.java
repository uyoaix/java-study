package com.study.yufei.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yufei.wang
 * @date 2021/03/30 16:11
 */
public class MyHmacUtils {


    String generateHmac256(String message, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] bytes = hmac("HmacSHA256", key, message.getBytes());
        return bytesToHex(bytes);
    }

    byte[] hmac(String algorithm, byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(message);
    }

    String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0, v; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String valueToDigest = "auth_date=1617084680\nid=1167120687\nphoto_url=https://t.me/i/userpic/320/ifxp0uoGR2QOuYqe1J7JQm6WULveRI-P_QCs9RPiAiQ.jpg\nfirst_name=Elvis";
        String secretKey = "1245527768:AAFBIS2IQzXOqqF9QG8J812_p8JL2AuylGk";
        byte[] key = secretKey.getBytes();

        MyHmacUtils hm = new MyHmacUtils();
        String messageDigest = hm.generateHmac256(valueToDigest, key);
        System.out.println(messageDigest);
    }
}
