package com.study.yufei.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal 数据操作工具
 *
 * @author yufei.wang
 * @date 2021/08/06 10:02
 */
public class BigDecimalUtils {

    /**
     * BigDecimal数据四舍五入
     * 1）整数时(没有小数)： 如25，末位为5需进位，四舍五入后为30；21四舍五入后为20
     * 2）小数时(有小数)    如12.321四舍五入后为12.23; 0.12347四舍五入后为0.1235
     *
     * @param amount 数据
     * @return java.math.BigDecimal
     * @author yufei.wang
     * @date 2021-08-06 10:04
     */
    public static BigDecimal round(BigDecimal amount) {

        // stripTrailingZeros 方法会把小数位末尾的0去掉：如 12.000,处理后就是12
        // toPlainString把BigDecimal数据转成字符串
        String amountStr = amount.stripTrailingZeros().toPlainString();
        BigDecimal finalAmount;
        if (amountStr.contains(".")) {
            // 字符串中包含点，说明是小数
            //切割字符串
            String[] amountStrArr = amountStr.split("\\.");
            // 获取小数位数
            int decimalLen = amountStrArr[1].length();
            if(decimalLen > 1){
                // 使用HALF_UP向上进位，精度长度位小数位减1
                finalAmount = amount.stripTrailingZeros().setScale(decimalLen - 1, RoundingMode.HALF_UP);
            } else {
                if(amount.stripTrailingZeros().compareTo(BigDecimal.valueOf(0.5)) >=0 ){
                    finalAmount = amount.stripTrailingZeros().setScale(0, RoundingMode.HALF_UP);
                } else {
                    finalAmount = amount.stripTrailingZeros().setScale(decimalLen, RoundingMode.HALF_UP);
                }
            }

        } else {
            // 整数
            int amountInt = amount.intValue();
            // 余数
            int remainder = amountInt % 10;
            // 十位数
            int tens = amountInt / 10;
            if (remainder >= 5) {
                // 余数大于等于5，十位进1
                tens += 1;
                amountInt = tens * 10;
            } else {
                amountInt = tens * 10;
            }
            finalAmount = BigDecimal.valueOf(amountInt);
        }
        return finalAmount;
    }

    public static void main(String[] args) {
        BigDecimal amount1 = new BigDecimal("12321");
        BigDecimal amount2 = new BigDecimal("15");
        BigDecimal amount3 = new BigDecimal("12");
        BigDecimal amount4 = new BigDecimal("15.0000000000");

        BigDecimal amount5 = new BigDecimal("165.231");
        BigDecimal amount6 = new BigDecimal("165.231000000000");
        BigDecimal amount7 = new BigDecimal("12.005");
        BigDecimal amount8 = new BigDecimal("0.1");
        BigDecimal amount9 = new BigDecimal("0.75");
        BigDecimal amount10 = new BigDecimal("0.01");



        System.out.println("12321 四舍五入后：" + round(amount1));
        System.out.println("15 四舍五入后：" + round(amount2));
        System.out.println("12 四舍五入后：" + round(amount3));
        System.out.println("15.0000000000 四舍五入后：" + round(amount4));

        System.out.println("165.231 四舍五入后：" + round(amount5));
        System.out.println("165.231000000000 四舍五入后：" + round(amount6));
        System.out.println("12.005 四舍五入后：" + round(amount7));
        System.out.println("0.1 四舍五入后：" + round(amount8));
        System.out.println("0.5 四舍五入后：" + round(amount9));
        System.out.println("0.0000001 四舍五入后：" + round(amount10));


    }

}
