package com.sam.stack;

import com.sam.BaseFunc;
import com.sam.samplesort.SortBase;

/**
 * @Author qiyunfei
 * @ClassName:StackSort
 * @Email: samqi1122@126.com
 * @Description: 堆排序
 * @Date: 2022/7/5 08:38
 */
public class StackSort extends SortBase {

    public static void main(String[] args) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);


            int[] clone =new int[input.length];
            System.arraycopy( input, 0, clone, 0, input.length );

            stackSort(input);

            if(!compare(clone,input)){
                System.out.println(String.format("input:%s", join(input)));
                System.out.println(String.format("clone:%s", join(clone)));
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
     * 大跟堆的最大值，在最开始，那么把最大值和末尾交换完成最大值
     */
    public static void stackSort(int[] input){
        if(input ==null || input.length <=1){
            return;
        }

        for (int i = 0; i < input.length; i++) {
            heapInsert(input,i);
        }

        int heapSize = input.length;
        // 交换首位置和末尾
        swap(input,0,--heapSize);
        while (heapSize >0){
            heapify(input,0,heapSize);
            swap(input,0,--heapSize);
        }
    }

    // 孩子上位（向堆中插入数据，保持大跟堆）当前数和父比较，如果大于父，则交换
    public static void heapInsert(int[] input,int index){
        while (input[index] > input[(index -1)/2]){
            swap(input,index,(index -1)/2);
            index = (index -1 )/2;
        }
    }

    // 父亲禅位（堆父亲下降）从一个位置出发，向下移动的过程
    public static void heapify(int[] input,int index,int heapSize){
        int leftChild = 2*index + 1;

        // index 的孩子作为判断条件：到达了堆最大值
        while (leftChild < heapSize){
            //从孩子找到最大值
            int maxChildIndex = leftChild +1 < heapSize && input[leftChild +1] > input[leftChild]?
                    leftChild +1 : leftChild;


            // 比较父亲和孩子
            if(input[index] >= input[maxChildIndex]){
                break;
            }

            swap(input,index,maxChildIndex);

            //index 下移
            index = maxChildIndex;
            leftChild = 2*index +1;
        }
    }



}
