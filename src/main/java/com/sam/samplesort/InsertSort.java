package com.sam.samplesort;

/**
 * @Author qiyunfei
 * @ClassName:InsertSort
 * @Email: samqi1122@126.com
 * @Description: 插入法排序
 * @Date: 2022/6/29 23:43
 */
public class InsertSort extends SortBase{

    public static void main(String[] args) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);


            int[] clone =new int[input.length];
            System.arraycopy( input, 0, clone, 0, input.length );

            insertSort(input);

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
     * 插入法排序类似于打扑克，每次拿到一张新牌之后把它插入到当前有序牌中，过程为：
     * 1. 检查o,1范围内是否有序，
     * 2. 检查0,2范围内是否有序
     * 一次类推，每次都把待排序的值在有序队列中找到正确的位置，
     * 找位置的过程是从后向前，如果当前值小于有序队列，则二者交换，否则保持不变
     *
     * O(N2)
     * @param input
     */
    public static void insertSort(int[] input){
        if(input == null || input.length <=1){
            return;
        }

        // 待排序值(乱序序列)
        for (int i = 0; i < input.length; i++) {
            int curIdx = i;

            // 和有序队列比较，如果当前值小于有序队列，则交换，否则停止（有序序列）
            for (int j = i-1; j >=0  ; j--) {
                if(input[curIdx] < input[j]){
                    swap(input,curIdx,j);
                    curIdx = j;
                }else{
                    break;
                }
            }
        }




    }
}
