package com.middleWare.rhino;

import com.dianping.rhino.annotation.Degrade;
import com.dianping.rhino.annotation.Rhino;

import java.util.Random;

@Rhino
public class Test {
    private Random random = new Random();

    @Degrade(rhinoKey = "getPrice", fallBackMethod = "fallBack")
    public int getPrice(int param) {
        int n = random.nextInt(10000);
        int m = 1;
        if (n > 9900) {
            m = 1 / 0;
        }
        return m;
    }

    // 降级方法，参数必须和主方法保持一致
    public int fallBack(int param) {
        return 0;
    }
}
