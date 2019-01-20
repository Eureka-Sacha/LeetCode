package com.eureka;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by @奎
 *
 * @date: @2019/1/20.
 * @mail:
 * @description: 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    public static boolean containsDuplicateMyself1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }

    public static boolean containsDuplicateMyself2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

        public static void main(String[] args) {
            int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            long start = System.currentTimeMillis();
            System.out.println(containsDuplicateMyself1(nums));
            System.out.println(Arrays.toString(nums));
            System.out.println(System.currentTimeMillis() - start + "ms");
            start = System.currentTimeMillis();
            System.out.println(containsDuplicateMyself2(nums));
            System.out.println(Arrays.toString(nums));
            System.out.println(System.currentTimeMillis() - start + "ms");

        }

}
