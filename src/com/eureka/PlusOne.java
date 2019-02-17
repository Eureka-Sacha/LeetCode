package com.eureka;

import java.util.Arrays;

/**
 * Created by @奎
 *
 * @date: @2019/2/17.
 * @mail:
 * @description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + 1;
            if (num > 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] result = new int[digits.length + 1];
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    result[0] = 1;
                    return result;
                }
            } else {
                digits[i] = num;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3,4})));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
