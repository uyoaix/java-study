package com.study.yufei.blockchain;

/**
 * @author yufei.wang
 * @date 2021/07/30 10:32
 */
public class MetaMaskSignTest {

    public static void main(String[] args) {

        String signature = "0x53134d4e87b69de1558f014398545bdc0a9535da4fbe15c7352e26b9489bcf6358ed98e87bdd48c5c226c2f29d4175545a77306df5a9594433e065e496ffc5221b";
        String message = "abcd";
        String address = "0xfcf6d3bd655e2ab76984176f1e089142436b8413";

        boolean validate = CryptoUtils.validate(signature, message, address);
        System.out.println("是否是当前地址签名：" + validate);


    }

}
