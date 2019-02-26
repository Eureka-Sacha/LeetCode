package com.eureka;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @奎
 *
 * @date: @2019/2/26.
 * @mail:
 * @description: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (a, b) -> a + b);
        }
        Integer i = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (i == null) {
                i = integerIntegerEntry.getKey();
            }
            if (map.get(i) < integerIntegerEntry.getValue()) {
                i = integerIntegerEntry.getKey();
            }
        }
        return i;
    }

    public static int majorityElement2(int[] nums) {
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    temp = nums[i];
                    count = 1;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 2, 3};
        long start = System.currentTimeMillis();
        System.out.println(majorityElement2(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(majorityElement(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

}
