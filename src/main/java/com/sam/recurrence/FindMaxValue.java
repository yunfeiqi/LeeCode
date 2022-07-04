package com.sam.recurrence;

import com.sam.BaseFunc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:FindMaxValue
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/4 21:27
 *
 * 用递归的方法求数组的最大值
 */
public class FindMaxValue extends BaseFunc {

    public static void main(String[] args) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);

            int maxValue = findMaxValue(input);

            int groundTrue = target(input);
            if(groundTrue != maxValue){
                System.out.println(String.format("input:%s", join(input)));
                System.out.println(String.format("maxValue:%s", maxValue));
                System.out.println(String.format("clone:%s", groundTrue));
                flag = false;
                break;
            }else {
                flag = true;
            }
        }

        if(flag){
            System.out.println("OK");
        }else{
            System.out.println("Failure");
        }
    }

    public static int findMaxValue(int[] input){
        if(input == null || input.length ==0){
            return -1;
        }
        return  findMaxValue(input,0,input.length-1);
    }

    // 把数据分为两部分，分别从左右两边找最大值
    // 比较左右两边的最大值
    public static int findMaxValue(int[] input,int left,int right){
        if(left == right){
            return  input[left];
        }

        //中点
        int mid = left + ((right- left) >> 1);
        //中点左侧
        int leftMax = findMaxValue(input, left, mid);
        //中点右侧
        int rightMax = findMaxValue(input,mid+1,right);
        //左右两边的最大值
        int max = Math.max(leftMax, rightMax);
        return max;
    }

    public static int target(int[] input){
        if(input == null || input.length == 0){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int item : input) {
            if(item > max){
                max = item;
            }
        }
        return  max;
    }
}

