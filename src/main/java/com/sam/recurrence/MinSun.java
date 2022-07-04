package com.sam.recurrence;

/**
 * @Author qiyunfei
 * @ClassName:MinSun
 * @Email: samqi1122@126.com
 * @Description: 小和问题
 * @Date: 2022/7/4 22:16
 *
 * 小和：数组中某个位置，左边比当前值小的数字之和称为小和，整个数组的小和就是所有的小和相加
 * 数组的小和：数组每个位置所有小和的和为数组的小和
 *
 * 提示：将问题转换为，数组中任意位置，右边有几个数字比当前数字大，就当前位置数值而言就会有几个小和
 * SortMerge 的 Merge 过程可以产生附加物，该过程可以计算小和。
 */
public class MinSun {

    public static void main(String[] args) {
        int[] input = new int[] {1,3,4,2,5};
        int predict = minSun(input);
        int target = 16;

        if(predict == target){
            System.out.println("Ok");
        }else{
            System.out.println("Failure");
        }

    }

    public static int minSun(int[] input){
        if(input == null || input.length <=1){
            return 0;
        }

        int minValue = mergeSort(input, 0, input.length - 1);
        return minValue;
    }

    public static int mergeSort(int[] input,int left,int right){
        // 递归终止条件
        if(left == right){
            return 0;
        }

        int mid = left + ((right - right) >> 1);
        int leftMinValue = mergeSort(input, left, mid);
        int rightMinValue = mergeSort(input, mid + 1, right);

        int mergeMinValue = merge(input, left, mid, right);
        return leftMinValue + rightMinValue + mergeMinValue;
    }

    public static int merge(int[] input,int left,int mid,int right){
        int[] helper = new int[right - left +1];
        int index = 0;

        int L = left;
        int R = mid + 1;

        int minValue = 0;

        while (L <= mid && R <= right){
            if(input[L] <= input[R]){
                if(input[L] == input[R]){
                    // 不产生小和，此时需要先拷贝右组数据，
                    // 因为如果先拷贝左组数据，此时在计算小和个数时将会产生错误
                    helper[index] = input[R++];
                }else{
                    helper[index] = input[L++];
                    // 产生小和
                    minValue += (right - R +1) * helper[index];
                }

                index +=1;
            }else{
                helper[index++] = input[R++];
            }
        }

        while (L <= mid){
            helper[index++] = input[L++];
        }

        while (R <= right){
            helper[index++] = input[R++];
        }

        for (int i = 0; i < helper.length; i++) {
            input[left + i ] = helper[i];
        }

        return minValue;
    }
}
