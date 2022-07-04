package com.sam.samplesort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author qiyunfei
 * @ClassName:SelectSort
 * @Email: samqi1122@126.com
 * @Description: 选择排序算法
 * @Date: 2022/6/28 22:19
 */
public class SelectSort {

    public static void main(String[] args) {

        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);

            int[] clone =new int[input.length];
            System.arraycopy( input, 0, clone, 0, input.length );

            selectSort(input);

            if(!compare(clone,input)){
                System.out.println(String.format("input:%s", join(input)));
                System.out.println(String.format("clone:", join(clone)));
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

    /**
     * 选择排序算法
     * 选择排序算法就是在给定的数组中从开始位置到最后一个位置，选择一个最小值放到数组开始，
     * 之后再从第二个位置到最后一个位置再选择一个最小值放到第二个位置，依次类推，直到数组的最后
     * 一个位置时结束。
     *
     * 时间复杂度：O(N2)
     */
    public static void selectSort(int[] input){
        if(input == null || input.length <=1){
            return;
        }

        // 外层循环控制 有序数组的最有段位置
        for (int i = 0; i < input.length-1; i++) {
            // 内层循环，控制待排序数组最左侧位置
            for (int j = i+1; j < input.length; j++) {
                if(input[i] > input[j]){
                    swap(input,i,j);
                }
            }
        }
    }

    public static void swap(int[] input,int i,int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    // 数组生成器
    public static int[] generator(int arrayLen){
        int[] array = new int[arrayLen];

        // 为Array 随机赋值
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30);
        }

        return  array;
    }

    public static boolean compare(int[] input,int[] target){
        boolean flag = true;
        int[] groundtrue = Arrays.stream(input).sorted().toArray();

       if(groundtrue.length != target.length){
           return !flag;
       }

        for (int i = 0; i < groundtrue.length; i++) {
            if(groundtrue[i] != target[i]){
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static String join(int[] input){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
            sb.append(",");
        }

        return sb.toString();
    }
}
