package com.sam.samplesort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author qiyunfei
 * @ClassName:SortBase
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/6/29 23:29
 */
public class SortBase {

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

    /**
     * 交换数组的元素
     * @param input
     * @param i
     * @param j
     */
    public static void swap(int[] input,int i ,int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
