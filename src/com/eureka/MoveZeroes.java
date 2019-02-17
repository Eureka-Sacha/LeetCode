package com.eureka;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by @奎
 *
 * @date: @2019/2/17.
 * @mail:
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int i;
        for (i = 0; i < len; ) {
            if (nums[i] == 0) {
                for (int n = i; n < nums.length; n++) {
                    int tmp = nums[n];
                    nums[n] = nums[n + 1 >= nums.length ? n : n + 1];
                    nums[n + 1 >= nums.length ? n : n + 1] = tmp;
                }
                len--;
                continue;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 0, 3, 0};
        long start = System.currentTimeMillis();
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }
}
