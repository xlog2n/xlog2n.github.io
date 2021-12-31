package com.bye404.demo.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * GoingUpstairs
 * 状态转移方程 f(n) = f(n-1) + f(n-2)
 * 最优子结构 f(10) 的最优子结构就是 f(9) + f(8)
 * 问题最小边界 n == 1 || n == 2
 *
 * @author liujia
 */
public class GoingUpstairs {

    // 计算给定数量楼梯的走法，递归方法，时间复杂度是O(2^n)，空间复杂度是O(2^n)
    private static int calc1(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num must be gt 0");
        }
        // 问题的边界
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        return calc1(num - 1) + calc1(num - 2);
    }

    // 计算给定数量楼梯的走法，递归方法，时间复杂度是O(n)，空间复杂度是O(n)
    static Map<Integer, Integer> cache = new HashMap<>(2<<16);
    private static int calc2(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num must be gt 0");
        }
        // 问题的边界
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        Integer value = cache.get(num);
        if (value != null) {
            return value;
        }
        value = calc1(num - 1) + calc1(num - 2);
        cache.put(num, value);
        return value;
    }

    // 计算给定数量楼梯的走法，真正的动态规划迭代方法，时间复杂度是O(n)，空间复杂度是O(1)
    // 根据最有子结构
    private static int calc3(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num must be gt 0");
        }
        // 问题的边界
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        int n1 = 1;
        int n2 = 2;
        int total = 0;
        for (int i = 3; i <= num; i++) {
            total = n1 + n2;
            n1 = n2;
            n2 = total;
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 38;

        long v1Start = System.currentTimeMillis();
        int v1 = calc1(n);
        long v1End = System.currentTimeMillis();
        System.out.println("使用递归计算 " + n + " 个楼梯的走法有：" + v1 + " 种，耗时：" + (v1End - v1Start) + "ms");

        long v2Start = System.currentTimeMillis();
        int v2 = calc2(n);
        long v2End = System.currentTimeMillis();
        System.out.println("使用递归优化方法计算 " + n + " 个楼梯的走法有：" + v2 + " 种，耗时：" + (v2End - v2Start) + "ms");

        long v3Start = System.currentTimeMillis();
        int v3 = calc3(n);
        long v3End = System.currentTimeMillis();
        System.out.println("使用动态规划迭代方法计算 " + n + " 个楼梯的走法有：" + v3 + " 种，耗时：" + (v3End - v3Start) + "ms");
    }
}
