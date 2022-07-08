package com.sam.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:Subsets
 * @Email: samqi1122@126.com
 * @Description: 子集 Leecode 78
 * @Date: 2022/7/7 22:34
 *
 * 题目给你输入一个无重复元素的数组nums，其中每个元素最多使用一次，请你返回nums的所有子集
 * List<List<Integer>> subsets(int[] nums)
 *
 * 比如输入nums = [1,2,3]，算法应该返回如下子集：
 * [ [],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3] ]
 */
public class Subsets {

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> trace = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        subsets(nums);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.printf("%d,",integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums){
        backtrace(nums,0);
        return res;
    }

    public static void backtrace(int[] nums,int start){

        // 前序，添加元素，trace 记录走过的路径值
        res.add(new LinkedList<>(trace));

        // 遍历选择
        for (int i = start; i < nums.length; i++) {
            // 做选择
            trace.addLast(nums[i]);

            // 回溯，继续下一个节点
            backtrace(nums,i + 1);

            // 撤销选择
            trace.removeLast();
        }



    }

}
