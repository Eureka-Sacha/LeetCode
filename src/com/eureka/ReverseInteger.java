package com.eureka;

/**
 * Created by @奎
 *
 * @date: @2019/1/20.
 * @mail:
 * @description: 7. 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */

public class ReverseInteger {
    public static int reverseMyself(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        switchChars(chars);
        if (!is32Bits(chars)) {
            return 0;
        }
        return Integer.parseInt(new String(chars));
    }

    private static void switchChars(char[] chars) {
        int len = chars.length % 2 == 0 ? chars.length / 2 : chars.length / 2 + 1;
        for (int i = 0; i < len; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        if (chars[chars.length - 1] == '-') {
            char perv = chars[chars.length - 1];
            for (int i = 0; i < chars.length - 1; i++) {
                char tmp = chars[i];
                chars[i] = perv;
                perv = tmp;
            }
            chars[chars.length - 1] = perv;
        }
    }

    private static boolean is32Bits(int n) {
        return n > (-1 << 31) && n < (1 << 31 - 1);
    }

    private static boolean is32Bits(char[] chars) {
        char[] min = String.valueOf(-1 << 31).toCharArray();
        char[] max = String.valueOf((1 << 31) - 1).toCharArray();
        if (chars[0] == '-' ? chars.length == min.length : chars.length == max.length) {
            int i = 0;
            char[] tmp = max;
            if (chars[0] == '-') {
                i = 1;
                tmp = min;
            }
            boolean before = true;
            for (; i < chars.length; i++) {
                if (before && Integer.parseInt(String.valueOf(chars[i])) > Integer.parseInt(String.valueOf(tmp[i]))) {
                    return false;
                } else {
                    before = before && Integer.parseInt(String.valueOf(chars[i])) > Integer.parseInt(String.valueOf(tmp[i]));
                }
            }
        }
        return true;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(reverseMyself(1534236469));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
