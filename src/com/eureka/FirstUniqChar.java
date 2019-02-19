package com.eureka;

import java.util.Arrays;

/**
 * Created by @奎
 *
 * @date: @2019/2/19.
 * @mail:
 * @description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = 0;
            for (; j < chars.length; j++) {
                if (j != i) {
                    if (chars[i] == chars[j]) {
                        break;
                    }
                }
            }
            if (j==chars.length){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(firstUniqChar("xswwweasvgq"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
