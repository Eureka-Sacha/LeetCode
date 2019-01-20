package com.eureka;

/**
 * Created by @奎
 *
 * @date: @2019/1/20.
 * @mail:
 * @description: 9.回文数.
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Palindrome {
    public static boolean isPalindromeMyself(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        if (len % 2 == 0) {
            return str.substring(0, len / 2).equals(new StringBuilder(str.substring(len / 2)).reverse().toString());
        } else {
            return str.substring(0, len / 2).equals(new StringBuilder(str.substring(len / 2 + 1)).reverse().toString());
        }
    }

    public static boolean IsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        int x = 12333211;
        long start = System.currentTimeMillis();
        System.out.println(isPalindromeMyself(x));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(IsPalindrome(x));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

}
