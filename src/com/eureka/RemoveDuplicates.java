package com.eureka;

import java.util.Arrays;

/**
 * Created by @奎
 *
 * @date: @2019/1/20.
 * @mail:
 * @description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length-len; ) {
                if (nums[i] == nums[j]) {
                    for (int x = nums.length - 1; x > j; x--) {
                        int tmp = nums[x];
                        nums[x] = nums[j];
                        nums[j] = tmp;
                    }
                    len += 1;
                }else{
                    j++;
                }
            }

        }
        return nums.length-len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 2, 2, 3, 4};
        long start = System.currentTimeMillis();
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
