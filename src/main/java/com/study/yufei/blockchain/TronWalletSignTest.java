package com.study.yufei.blockchain;



/**
 * @author yufei.wang
 * @date 2021/07/30 12:03
 */
public class TronWalletSignTest {


    public static void main(String[] args) {

        String data = "abcd";
        String signature = "0xe50515b8bf77fb29ab751de95dcbccf20b789f26cf108d570d1dcffc3c280db025d2922793c395b3ef54cc99a5a54803084fada6dc41c2568a8f3db99c3322051b";
        String address = "TQSjuppYs3jEtWDrbc9S6B5ugAFKskfH4B";

        boolean verify = TronCryptoUtils.validate(data, signature, address);
        System.out.println("trx钱包签名验证：" + verify);


    }
}
