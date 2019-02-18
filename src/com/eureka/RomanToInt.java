package com.eureka;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @奎
 *
 * @date: @2019/2/19.
 * @mail:
 * @description: 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInt {
    static Map<String, Integer> ROMAN_INT = new HashMap<>();

    static {
        ROMAN_INT.put("M", 1000);
        ROMAN_INT.put("D", 500);
        ROMAN_INT.put("C", 100);
        ROMAN_INT.put("L", 50);
        ROMAN_INT.put("X", 10);
        ROMAN_INT.put("V", 5);
        ROMAN_INT.put("I", 1);
        ROMAN_INT.put("IV", 4);
        ROMAN_INT.put("IX", 9);
        ROMAN_INT.put("XL", 40);
        ROMAN_INT.put("XC", 90);
        ROMAN_INT.put("CD", 400);
        ROMAN_INT.put("CM", 900);
    }

    public static int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length ; i > 0; i--) {
            int src = i - 2 < 0 ? 0 : i - 2;
            if (ROMAN_INT.containsKey(s.substring(src, i))) {
                result += ROMAN_INT.get(s.substring(src, i));
                i -= 1;
            } else {
                result += ROMAN_INT.get(s.substring(i-1, i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(romanToInt("III"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
