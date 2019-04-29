package com.learn.algorithm.array;

/**
 * LeetCode 303. Range Sum Query
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * @author guoxingyong
 * @data 2019/4/29 10:28
 */
public class RangeSumQuery {
    private int[] sum;
    //这题主要是就考，你需要在原数组传递过来的时候把他变成另外一个数组，数组的每个元素为原来下标前所有数的总和
    public RangeSumQuery(int[] nums) {
        int length = nums.length;
        sum = new int[length+1];
        for (int i = 0; i < length; i++) {
            sum[i+1]=sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}


