package com.sam.samplesort;

/**
 * @Author qiyunfei
 * @ClassName:BubbleSort
 * @Email: samqi1122@126.com
 * @Description: 冒泡排序
 * @Date: 2022/6/29 23:10
 */
public class BubbleSort extends SortBase{

    public static void main(String[] args) {
        boolean flag = false;

        for (int i = 0; i < 30; i++) {
            int[] input = null;
            input  = generator(i);


            int[] clone =new int[input.length];
            System.arraycopy( input, 0, clone, 0, input.length );

            bubbleSort(input);

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
     * 冒泡排序算法
     *
     * 冒泡排序就好像气泡从底部到顶部升起的过程，它需要将每个项和邻居比较大小，如果当前数字比邻居大那么就
     * 交换，当遍历完一次数组后，最大值就在数组的底部。之后继续重复之前过程，只不过数据需要减去排好序的部分。
     *
     * 每次迭代时，保持当前元素是最大值，最后把最大值放到数组的最后
     *
     * O(n2)
     * @param input
     */
    public static void bubbleSort(int[] input){
        if(input == null || input.length <=1){
            return;
        }

        // 对整个数组进行冒泡排序
        for (int i = 0; i < input.length; i++) {

            // 遍历待排序部分
            for (int j = 0; j < input.length - i -1; j++) {
                //检查当前元素和邻居，如果大于邻居则与邻居交换，保持当前元素是整个数组最大值
                if(input[j] > input[j+1]){
                    swap(input,j,j+1);
                }
            }
        }
    }
}
