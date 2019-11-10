package com.fei.demo.leetcode;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 5, 4, 3
        };
        int sum = 9;
        int[] result = twoSum(a,sum);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] pos = new int[2];
        for (int pos1 = 0; pos1 < nums.length - 1; pos1++) {
            for (int pos2 = pos1 + 1; pos2 < nums.length; pos2++) {
                if (nums[pos1] + nums[pos2] == target) {
                    pos[0] = pos1;
                    pos[1] = pos2;
                }
            }
        }
        return pos;
    }
}
