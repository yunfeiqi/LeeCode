package com.sam.samplesort;

import java.util.Random;

/**
 * @Author qiyunfei
 * @ClassName:FindNumber
 * @Email: samqi1122@126.com
 * @Description: 找数字
 * @Date: 2022/6/30 00:06
 *
 * 给定一个数组，已知只有一种数字出现了奇数次，其他出现偶数次，找到它
 */
public class FindNumber extends SortBase{

    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber =0;

        int[] input = new int[]{0,0,0,2,3,2,2,2,3,3,3,3,3,4,6,4,6};

        int number = findNumber(input);
        if(targetNumber == number){
            System.out.println("Ok");
        }else {
            System.out.println("Failure");
        }
    }

    /**
     * ### 异或运算
     * 1. 异或运算也可以视为无进位相加
     * 2. 异或运算满足交换律和结合律
     * 3. 相同为0，不同为1
     * 4. 0 ^ N = N
     * 5. N ^ N = 0
     * @param input
     * @return
     */
    public static int findNumber(int[] input){
        if(input == null || input.length ==0){
            return -1;
        }
        if(input.length ==1){
            return 0;
        }

        int number = 0;
        for (int item : input) {
            number ^= item;
        }
        return number;
    }

    public static int[] generator(int arrayLen,int targetNumber){
        int[] array = new int[arrayLen];

        // 为Array 随机赋值
        Random random = new Random();
        int times = 0;
        for (int i = 0; i < array.length-1; i++) {
            int value = random.nextInt(30);
            if(targetNumber == value){
                times +=1;
            }
            array[i] = random.nextInt(30);
        }

        if(times % 2 ==0){
            array[arrayLen-1] = targetNumber;
        }else{
            array[arrayLen-1] = random.nextInt(40);
        }

        return  array;
    }
}
