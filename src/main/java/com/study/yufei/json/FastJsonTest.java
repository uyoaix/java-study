package com.study.yufei.json;

import com.alibaba.fastjson.JSON;

/**
 * @author yufei.wang
 * @date 2021/03/02 11:34
 */
public class FastJsonTest {

    public static void main(String[] args) {
        String message = "{\"linkType\":2,\"linkNo\":\"111\",\"orderNo\":\"B01234233322322\",\"betAmount\":1,\"award\":2,\"validBetAmount\":1,\"userId\":100000001,\"currency\":\"BTC\"}";

        SettleOrderReq settleOrderReq = JSON.parseObject(message, SettleOrderReq.class);
        System.out.println();
    }
}
