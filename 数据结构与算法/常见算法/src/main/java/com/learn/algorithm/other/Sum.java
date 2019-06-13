package com.learn.algorithm.other;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * leetcode 15:3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * @author guoxingyong
 * @data 2019/5/23 10:02
 */
public class Sum {
    //todo 看不懂
    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        int[] nums = new int[]{0,0,0,0};
        String s="ss";
        System.out.println(threeSum(nums));
    }
}
