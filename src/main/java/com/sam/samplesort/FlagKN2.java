package com.sam.samplesort;

/**
 * @Author qiyunfei
 * @ClassName:FlagKN2
 * @Email: samqi1122@126.com
 * @Description: 荷兰国旗2
 * @Date: 2022/7/3 17:58
 *
 * 给定一个数组，和一个数num，请把小于num的数放到数组的左边，等于num的数字放中间，大于num的数放到数组右边，
 * 要求空间复杂度为O(1)，时间复杂度为O(N)
 */
public class FlagKN2 extends SortBase{

    public static void main(String[] args) {
        int[] input = new int[]{0,0,12,10,4,5,6,5,5,11,3,5,4,6,7,1,0,4};
        int number = 5;

        System.out.println(String.format("Origin:%s",join(input)));
        flagKN(input,number);
        System.out.println(String.format("New:%s",join(input)));
    }


    /**
     *
     * @param input
     * @param number
     */
    public static void flagKN(int[] input,int number){
        if(input == null || input.length <=1){
            return;
        }

        //当前值
        int index = 0;
        //小于区域
        int lowerDomain = -1;
        //大于区域
        int upperDomain = input.length;

        while (index < input.length && index < upperDomain){
            // 规则1：当前值小于 number； 当前值和小于区域前面的值交换，小于区域前移
            if(input[index] < number){
                swap(input,lowerDomain +1,index);
                lowerDomain +=1;
                index +=1;
            } else if (input[index] == number) {
                // 规则2：如果当前值等于 number 则直接位移下一个数值
                index += 1;
            } else {
                // 规则3：如果当前值大于number，则当前值和大于区域前面值交换，大于区域前移
                swap(input,index,upperDomain-1);
                // 大于区域前移
                upperDomain -=1;
            }
        }

        System.out.println("Lower:" + lowerDomain);
        System.out.println("Upper:"+ upperDomain);


    }



}
