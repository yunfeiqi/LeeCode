package com.sam.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:Permute
 * @Email: samqi1122@126.com
 * @Description: 全排列, LeeCode 46题
 * @Date: 2022/7/6 17:15
 *
 * 给你输入一个数组 nums，让你返回这些数字的全排列。
 * 我们这次讨论的全排列问题不包含重复的数字
 */
public class Permute {

    private static List<LinkedList<Integer>> res = new ArrayList<>();

    /**
     * 输入一组不重复的数字，返回它们的全排列
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        traverse(nums,new LinkedList<>());

        for (LinkedList<Integer> re : res) {
            for (Integer integer : re) {
                System.out.printf("%d,",integer);
            }
            System.out.println();
        }

        System.out.println(res.size());
    }

    /**
     * 路径： 当前选中的节点：记录在track中
     * 选择列表：当前剩下的选择：那些不在track中的元素
     * 结束条件：树的底层叶子节点，也就是选择列表为空的时候：nums所有值都在 track中
     */
    public static void traverse(int[] nums, LinkedList<Integer> track){
        //结束条件：所有值都在 track中
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        // 遍历状态
        for (int num : nums) {
            // 选择过滤，去除track 中已经存在的num
            if(track.contains(num)){
                continue;
            }

            // 做出选择： 将num 添加到 track中
            track.add(num);

            // 进入下层
            traverse(nums,track);
            // 撤销选择
            track.pop();
        }

    }
}
