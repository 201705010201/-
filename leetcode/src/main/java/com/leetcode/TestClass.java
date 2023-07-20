package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {

    /**
     * 删除重复元素
     * @param array int整型一维数组
     * @return int整型一维数组
     */

    public static void main(String[] args) {
        int[] ints = {3,5,8,2,3,8};
        removeDuplicate(ints);
    }

    // int[] = {5,2,3,8}
    public static void removeDuplicate (int[] array) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for(int i = array.length-1;i >= 0; i--){
            linkedHashSet.add(array[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int k: linkedHashSet) {
            list.add(k);
        }

        Collections.reverse(list);

        int[] resultInt = new int[list.size()];
        int index = 0;
        for(int k: list){
            resultInt[index++] = k;
        }
    }


    // int[] = {5,2,3,8}
//    private static void removeDuplicate(int[] array) {
//
//        List<Integer> list = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (!set.contains(array[i])) {
//                set.add(array[i]);
//                list.add(array[i]);
//            }
//        }
//
//        //倒序
//        Collections.reverse(list);
//
//        int[] resultInt = new int[list.size()];
//
//        for (int i = 0; i < list.size(); i++) {
//            resultInt[i] = list.get(i);
//        }
//    }
}
