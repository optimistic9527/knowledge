package com.learn.algorithm.array;

import java.util.Arrays;

/**
 * LeetCode704. Binary Search
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 * @author guoxingyong
 * @data 2019/4/28 18:49
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int result = -1;
        while (startIndex <= endIndex) {//当endIndex小于startIndex就结束了
            int index = (startIndex + endIndex) >>> 1;
            int indexNum = nums[index];
            if (indexNum == target) {
                result = index;
                break;
            } else {
                if (target > indexNum) {//目标元素在中间元素的右边，那么把起始的index移动到中间index的后一位
                    startIndex = index + 1;
                } else {
                    endIndex = index - 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{2, 5};

        int i = Arrays.binarySearch(ints, 2);
        System.out.println(i);
        System.out.println(search(ints, 5));
    }
}
