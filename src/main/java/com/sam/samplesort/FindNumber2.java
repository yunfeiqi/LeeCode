package com.sam.samplesort;

import java.util.Random;

/**
 * @Author qiyunfei
 * @ClassName:FindNumbe2
 * @Email: samqi1122@126.com
 * @Description: 找数字 版本2
 * @Date: 2022/6/30 00:24
 *
 * 给定一个数组，已知只有两种数字出现了奇数次，其他出现偶数次，找到它们（提示：将最终的异或结果按位置拆开）
 */
public class FindNumber2 {

    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber1 =0;
        int targetNumber2 =8;

        int[] input = new int[]{0,0,0,2,3,2,2,2,3,3,3,3,3,4,6,8,8,8,4,6};

        int[] number = findNumber(input);

        int target =0;

        target = targetNumber1 ^ targetNumber2 ^ number[0] ^ number[1];

        if(target == 0){
            System.out.println("Ok");
        }else {
            System.out.println("Failure");
        }
    }

    public static int[] findNumber(int[] input){
        if(input == null || input.length <=1){
            return null;
        }

        if(input.length ==2){
            return  input;
        }

        int number = 0;
        for (int i = 0; i < input.length; i++) {
            number ^= input[i];
        }

        // 找到 number 二进制表示最右边第一个为1 的位置
        int flag = (~number +1) ^ number;

        //按照 flag 把数组分成两部分，flag位置为1和flag位置为0
        // 把flag 位置为1的一组做异或操作

        int number2 = 0;
        for (int i = 0; i < input.length; i++) {
            if((input[i] & flag) !=0){
                number2 ^=input[i];
            }
        }

        int target = number ^ number2;
        return new int[]{number2,target};
    }
}
