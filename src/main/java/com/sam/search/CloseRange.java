package com.sam.search;

/**
 * @Author qiyunfei
 * @ClassName:CloseRange
 * @Email: samqi1122@126.com
 * @Description: 二分查找算法，搜索区间是一个闭区间 [left,right]
 * @Date: 2022/7/13 15:27
 *
 * 在一个数组中搜索一个数，如果存在，返回其索引，否则返回 -1。
 *
 * While 终止条件： 搜索区间为空的时候应该终止，
 *  while(left <= right) 的终止条件是left == right + 1，写成区间的形式就是[right + 1, right]
 *  while(left < right)  的终止条件是left == right，写成区间的形式就是[left, right]
 */
public class CloseRange {


    /**
     * 二分查找的细节：
     * 1. 搜索区间：[left,right]
     * 2. 中点计算方法，防止数值溢出：left + (right-left) >> 1
     * 3. 区间变化时 mid 的变化：
     *      input[mid] < target ===> left = left + 1
     *      input[mid] > target ===> right = right - 1
     * @param input
     * @param target
     * @return
     */
    public static int binarySearch(int[] input,int target){
        if(input == null || input.length <=0) return -1;

        // 搜索空间为闭区间：[left,right]
        int left =0;
        int right = input.length-1;

        // while 终止条件：搜索空间为空
        while (left <= right){
            int mid = left + (right - left) >> 1;
            if(input[mid] == target){
                return mid;
            } else if (input[mid] > target) {
                right = mid -1;
            } else if (input[mid] < target) {
                left = mid +1;
            }
        }

        // 都未找到 target 返回 -1
        return -1;
    }

}
