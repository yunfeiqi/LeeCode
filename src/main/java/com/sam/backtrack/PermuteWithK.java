package com.sam.backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:PermuteWithK
 * @Email: samqi1122@126.com
 * @Description: K个元素的全排列
 * @Date: 2022/7/8 11:02
 *
 * 题目不让你算全排列，而是让你算元素个数为k的排列
 */
public class PermuteWithK {

    public static List<List<Integer>> res = new LinkedList<>();
    public static HashMap<Integer,Boolean> used = new HashMap<>();

    public static void main(String[] args) {
        LinkedList<Integer> trace = new LinkedList<>();
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        traceback(nums,trace,k);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.printf("%d,",integer);
            }
            System.out.println();
        }
    }

    public static void traceback(int[] nums , LinkedList<Integer> trace, int k){
        // base case
        if(trace.size() == k){
            res.add(new LinkedList<>(trace));
            return;
        }

        // 遍历状态(排列)
        for (int num : nums) {

            if(used.getOrDefault(num,false)){
                continue;
            }

            // 做选择
            trace.addLast(num);
            used.put(num,true);

            // 回溯
            traceback(nums,trace,k);

            // 撤销选择
            trace.removeLast();
            used.put(num,false);
        }
    }
}
