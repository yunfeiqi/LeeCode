package com.sam.recurrence;

/**
 * @Author qiyunfei
 * @ClassName:InvertPair
 * @Email: samqi1122@126.com
 * @Description: 逆序对
 * @Date: 2022/7/4 22:45
 *
 * 数组中，左边的数如果比右边的数大，则两个数构成一个逆序对，请打印所有逆序对。
 */
public class InvertPair {

    public static void main(String[] args) {
        int[] input = new int[] {1,3,4,9,2,5,2};
        mergeSort(input);

        System.out.println(cnt);

    }

    private static int cnt = 0;

    public static void mergeSort(int[] input){
        if(input == null || input.length <=1){
            return;
        }

        mergeSort(input,0,input.length-1);
    }

    public static void mergeSort(int[] input,int left,int right){
        if(left == right){
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeSort(input,left,mid);
        mergeSort(input,mid + 1 ,right);
        merge(input,left,mid,right);
    }

    public static void merge(int[] input,int left,int mid ,int right){
        int[] helper = new int[right-left +1];
        int index = 0;

        int L = left;
        int R = mid + 1;
        while (L <= mid && R <= right){
            if(input[L] <= input[R]){
                helper[index++] = input[L++];
            } else {
                // 产生逆序对
                cnt += (mid - L) +1;
                //打印逆序对,Left 比右边当前值都大
                for (int i = L; i <= mid ; i++) {
                    System.out.println(String.format("==>%s:%s", input[i],input[R]));
                }

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
            input[left + i] = helper[i];
        }
    }
}
