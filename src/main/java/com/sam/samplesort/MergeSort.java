package com.sam.samplesort;

/**
 * @Author qiyunfei
 * @ClassName:MergeSort
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/4 21:52
 *
 * 归并排序
 * 1. 左边先排好序
 * 2. 右边排好序
 * 3. 左右两边合并
 *      左 小于 等于 右 => copy left
 *      左 大于 右  => copy right
 */
public class MergeSort  extends  SortBase{

    public static void main(String[] args) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);


            int[] clone =new int[input.length];
            System.arraycopy( input, 0, clone, 0, input.length );

            // quickSortV1
            mergeSort(input);

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

    public static void mergeSort(int[] input){
        if(input == null || input.length <=1){
            return;
        }

        mergeSort(input,0,input.length-1);
    }

    public static void mergeSort(int[] input,int left,int right){
        // 递归终止条件
        if(left == right){
            return;
        }

        int mid = left + ((right - right) >> 1);
        // 左边有序
        mergeSort(input,left,mid);
        // 右边有序
        mergeSort(input,mid +1 ,right);
        // 整体有序
        merge(input,left,mid,right);

    }

    public static void merge(int[] input,int left,int mid ,int right){
        // 帮助数据，用来保存有序数组
        int[] helper = new int[right - left +1];
        int i = 0 ;

        //原始数组指针
        int L = left;
        int R = mid + 1;

        //先遍历一组有序序列
        while (L <= mid && R <= right){
          if(input[L] <= input[R]){
              helper[i++] = input[L++];
          }else{
              helper[i++] = input[R++];
          }
        }

        //copy 左边
        while (L <=mid){
            helper[i++] = input[L++];
        }

        //copy 右边
        while (R <= right){
            helper[i++] = input[R++];
        }

        // 赋值
        for (int j = 0; j < helper.length; j++) {
            input[left + j] = helper[j];
        }
    }
}
