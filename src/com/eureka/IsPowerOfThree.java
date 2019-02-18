package com.eureka;

/**
 * Created by @奎
 *
 * @date: @2019/2/17.
 * @mail:
 * @description: 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 27
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfThree {
    public static boolean isPowerOfThree1(int n) {
        if (n <= 0) return false;
        for (int i = n; i > 1; i /= 3) {
            if (i % 3 != 0) return false;
        }
        return true;
    }

    //抄自leetcode题目评论区;
    //牛逼不解释
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isPowerOfThree1(9));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(isPowerOfThree2(9));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

}
