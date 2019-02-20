package com.eureka;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @奎
 *
 * @date: @2019/2/19.
 * @mail:
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.toCharArray().length != t.toCharArray().length) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char a = sChars[i];
            char b = tChars[i];
            if (sMap.containsKey(a)) {
                sMap.put(a, sMap.get(a) + 1);
            } else {
                sMap.put(a, 1);
            }
            if (tMap.containsKey(b)) {
                tMap.put(b, tMap.get(b) + 1);
            } else {
                tMap.put(b, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character key=entry.getKey();
            if (!tMap.containsKey(key) || !tMap.get(key).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
