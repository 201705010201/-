package com.leetcode;

import java.util.HashSet;


public class LeetCode349 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersection(nums1, nums2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (Integer n :nums1) {
            set1.add(n);
        }
        for (Integer m :nums2) {
            set2.add(m);
        }
        return getData(set1, set2);
    }

    private static int[] getData(HashSet<Integer> set1, HashSet<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getData(set2, set1);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer integer:set1) {
            if (set2.contains(integer)) {
                hashSet.add(integer);
            }
        }

        //将set转为int[]
        int[] ints = new int[hashSet.size()];
        int index = 0;
        for (Integer nu: hashSet) {
            ints[index++] = nu;
        }
        return ints;
    }

}
