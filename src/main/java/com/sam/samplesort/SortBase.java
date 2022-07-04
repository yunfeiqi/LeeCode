package com.sam.samplesort;

import com.sam.BaseFunc;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author qiyunfei
 * @ClassName:SortBase
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/6/29 23:29
 */
public class SortBase extends BaseFunc {

    public static boolean compare(int[] input,int[] target){
        boolean flag = true;
        int[] groundtrue = Arrays.stream(input).sorted().toArray();

        if(groundtrue.length != target.length){
            return !flag;
        }

        for (int i = 0; i < groundtrue.length; i++) {
            if(groundtrue[i] != target[i]){
                flag = false;
                break;
            }
        }

        return flag;
    }
}
