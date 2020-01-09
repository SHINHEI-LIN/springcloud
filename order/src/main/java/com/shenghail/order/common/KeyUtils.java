package com.shenghail.order.common;

import java.util.Random;

public class KeyUtils {
    /**
     * 生成一个订单编号
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int ran = random.nextInt(100);
        return String.valueOf(System.currentTimeMillis()) + String.valueOf(ran);
    }
}
