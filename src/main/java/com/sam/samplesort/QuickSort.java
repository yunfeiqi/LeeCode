package com.sam.samplesort;

import java.util.Random;

/**
 * @Author qiyunfei
 * @ClassName:QuickSort
 * @Email: samqi1122@126.com
 * @Description: 快排序
 * @Date: 2022/6/30 00:42
 */
public class QuickSort extends SortBase {

    public static void main(String[] args) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);


            int[] clone =new int[input.length];
            System.arraycopy( input, 0, clone, 0, input.length );

            // quickSortV1
            quickSortV1(input,0,input.length-1);

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


    public static void quickSortV1(int[] input,int left,int right){

        if(left < right){
            // 随机选择，交换
            swap(input,right,left +  (int)Math.random()* (right - left +1));
            // 外层排序
            int[] partition = partition(input, left, right);
            // 小于区域内操作
            quickSortV1(input,left,partition[0]-1);
            // 大于区域内操作
            quickSortV1(input,partition[1]+1,right);
        }

    }

    /**
     * 荷兰国旗问题
     * 1. 拿最后一个位置作为number，把[0,length -1] 区域内
     *  做到小于number在左边，等于number 在中间，大于number在后边
     * 2. 那最后一个数和大于区域第个数交换
     * @param input
     * @param left
     * @param right
     * @return 小于区域的右边界和大于区域的左边界（不包括边界）= 等于区域的左边界和有边界（包括边界）
     */
    public static int[] partition(int[] input,int left,int right){

        // 荷兰国旗问题
        int lessDomain =  left -1;
        int upperDomain = right;
        while (left < upperDomain){
            // < 情况
            if(input[left] < input[right]){
                swap(input,++lessDomain,left++);
            } else if (input[left] == input[right]) {
                left ++;
            }else {
                swap(input,left,--upperDomain);
            }
        }

        // 把最后已给位置和大于区域前的第一个值交换
        swap(input,upperDomain,right);
        return new int[]{lessDomain+1,upperDomain};
    }

}
