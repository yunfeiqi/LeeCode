package com.sam.samplesort;

/**
 * @Author qiyunfei
 * @ClassName:FLagKN
 * @Email: samqi1122@126.com
 * @Description: 荷兰国旗问题-版本1
 * @Date: 2022/6/30 00:47
 *
 * 给定一个数组，和一个数num，请把小于等于num的数放到数组的左边，大于num的数放到数组右边，
 * 要求空间复杂度为O(1)，时间复杂度为O(N)
 */
public class FLagKN extends SortBase{


    public static void main(String[] args) {
        int[] input = new int[]{0,99,2,3,4,6,7,1,4,10};
        int number = 5;

        System.out.println(String.format("Origin:%s",join(input)));
        flagKN(input,number);
        System.out.println(String.format("New:%s",join(input)));
    }

    /**
     * 0,3,4,2,3,5,5
     *
     * 划定一个小于等于范围，lowerDomain,在该范围内所有值都是小于number，之后遍历数组
     * 遍历规则：
     * 1. 当前值如果小于等于number，则
     *   a. 把当前值和小于等于区域前面的的值交换
     *   b. 当前指针 +1
     *   c. 小于等于区域 +1
     * 2. 当前值如果大于number 则
     *   当前指针 +1
     * @param input
     * @param number
     */
    public static void flagKN(int[] input,int number){
        if(input == null || input.length <=1){
            return;
        }

        //另一左右两个指针
        int left = 0;
        int lowerDoman = -1;

        while (left < input.length && lowerDoman < input.length){
            if(input[left] <= number){
                // 将当前值和小于等于区域的前面的交换
                swap(input,lowerDoman +1 ,left);

                // 当前坐标加1
                left += 1;
                // 小于等于区域前移
                lowerDoman +=1;
            }else{
                left += 1;
            }
        }

        System.out.println(lowerDoman);


    }

}
