package com.study.yufei.crypto;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

/**
 * @author yufei.wang
 * @date 2021/03/30 16:27
 */
public class ApacheHmacUtils {

//    data_check_string = ...
//    secret_key = SHA256(<bot_token>)
//if (hex(HMAC_SHA256(data_check_string, secret_key)) == hash) {
//        // data is from Telegram
//    }


    public static void main(String[] args) {




        String valueToDigest = "auth_date=1617096188\nfirst_name=Alan\nid=1104952154\nusername=alan_111";
        String secretKey = "1245527768:AAFBIS2IQzXOqqF9QG8J812_p8JL2AuylGk";

        byte[] data = valueToDigest.getBytes();
        byte[] secret = DigestUtils.sha256(secretKey);
        String hmac = HmacUtils.hmacSha256Hex(secret, data);
        System.out.println(hmac);

    }

}
