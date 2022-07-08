package com.sam.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author qiyunfei
 * @ClassName:Combine
 * @Email: samqi1122@126.com
 * @Description: 组合 Leecode77
 * @Date: 2022/7/8 10:48
 *
 * 给定两个整数n和k，返回范围[1, n]中所有可能的k个数的组合。
 */
public class Combine {

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> trace = new LinkedList<>();

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        backtrace(nums,trace,0,k);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.printf("%d,",integer);
            }
            System.out.println();
        }
    }

    public static void backtrace(int[] nums, LinkedList<Integer> trace, int start,int k){
        // 结束条件
        if(trace.size() == k){
            res.add(new LinkedList<>(trace));
            return;
        }

        // 遍历选择
        for (int i = start; i < nums.length; i++) {
            // 做选择
            trace.addLast(nums[i]);
            // 回溯
            backtrace(nums,trace,i+1,k);
            // 撤销选择
            trace.removeLast();
        }


    }
}
