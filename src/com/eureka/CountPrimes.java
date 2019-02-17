package com.eureka;

/**
 * Created by @奎
 *
 * @date: @2019/2/17.
 * @mail:
 * @description: 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(countPrimes(10000000));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
