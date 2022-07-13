package com.sam.search;

/**
 * @Author qiyunfei
 * @ClassName:LeftBound
 * @Email: samqi1122@126.com
 * @Description: 二分法查找有序数组的左边界
 * @Date: 2022/7/13 15:46
 */
public class LeftBound {

    /**
     * 搜索区间：[left,right]
     * while 终止条件:搜索区间为空 left >  right
     * 查找左区间：
     *  input[mid] > target =====> right = mid -1
     *  input[mid] < target =====> left = left + 1
     *  input[mid] = target =====> right = mid -1
     *
     * 检查越界：
     *  没有左边界：if (left >= nums.length || nums[left] != target) return -1;
     * @param input
     * @param target
     * @return
     */
    public static int leftBound(int[] input,int target){
        if(input == null || input.length <=0) return  -1;

        int left = 0;
        int right = input.length-1;

        while (left <= right){
            int mid = left + (right - left) >> 1;
            if(input[mid] > target){
                right = mid -1;
            } else if (input[mid] < target){
                left = mid +1;
            } else if (input[mid] == target) {
                right = mid -1;
            }
        }

        if(left >= input.length || input[left] != target){
            return  -1;
        }
        return  left;
    }
}
