package com.eureka;

/**
 * Created by @奎
 *
 * @date: @2019/2/20.
 * @mail:
 * @description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindromeString {
    public static boolean isPalindrome(String s) {
        String newStr = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (newStr.length() % 2 == 0) {
            return newStr.substring(0, newStr.length() / 2).equals(new StringBuilder(newStr.substring(newStr.length() / 2)).reverse().toString());
        } else {
            return newStr.substring(0, newStr.length() / 2).equals(new StringBuilder(newStr.substring(newStr.length() / 2 + 1)).reverse().toString());
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isPalindrome("race a car"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
