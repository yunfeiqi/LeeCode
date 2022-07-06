package com.sam.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author qiyunfei
 * @ClassName:fib
 * @Email: samqi1122@126.com
 * @Description: 斐波那契数列
 * @Date: 2022/7/6 09:51
 */
public class fib {

    /**
     * 缓存计算的中间结果
     */
    public static HashMap<Integer,Integer> cache = new HashMap();

    public static void main(String[] args) {
        // 暴力求解
//        violence();

        // 带有备忘录（缓存） 的方法
        withCache();

        // 自底向上 动态规划
        dynamic();
    }

    /**
     * 暴力求解
     */
    public static void violence(){
        long start = System.currentTimeMillis();
        for (int i = 1; i < 50; i++) {
            fib01(i);
        }
        long end = System.currentTimeMillis();
        System.out.printf("暴力求解 耗时：%d\n",end - start);

    }

    /**
     * 带有备忘录（缓存）的方法
     */
    public static void withCache(){
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            fib02(i);
        }
        long end = System.currentTimeMillis();
        System.out.printf("带缓存 耗时：%d\n",end - start);

    }

    /**
     * 动态规划方法
     */
    public static void dynamic(){
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            fib03(i);
        }
        long end = System.currentTimeMillis();
        System.out.printf("动态规划 耗时：%d\n",end - start);
    }

    /**
     * 递归方法计算斐波那契数列
     * 暴力递归的方法，采用这种递归的方法F(18) 被计算了很多次
     * 计算F(19)和F(20)都使用了F(18)，但是F(18)的结果并没有被缓存，导致了重复计算
     * 这就是重叠子问题。
     */
    public static int fib01(int N){
        if(N ==1 || N ==2){
            return 1;
        }

        return  fib01(N-1) + fib01(N-2);
    }

    /**
     * 带有备忘录（缓存）的斐波那契数据计算方法
     *
     * 自顶向下 的 递归 求解方法
     * 从一个规模大的问题，逐级分解模型，直到遇到两个 base case F(1) F(2)
     * @param N
     * @return
     */
    public static int fib02(int N){
        if(N ==1 || N == 2){
            return 1;
        }

        Integer first = cache.getOrDefault(N - 1,null);
        Integer second = cache.getOrDefault(N - 2,null);

        if(first == null){
            first = fib02(N - 1);
            cache.put(N-1,first);
        }

        if(second == null){
            second = fib02(N - 2);
            cache.put(N-2,second);
        }

        return first + second;
    }

    /**
     * 动态规划方法
     *
     * 动态规划是一种 自底向上 递推 的一种算法模型
     * 它是从 base case 开始 并结合 缓存 实现的一种解决问题的方法
     *
     * 动态规划的方法一般采用循环而非递归的方式
     *
     * @param N
     * @return
     */
    public static int fib03(int N){
        if(N == 0) return  0;

        // base case
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,1);

        // 状态转移 公式
        for (int i = 3; i <= N; i++) {
            cache.put(i,cache.get(i-1) + cache.get(i-2));
        }

        return cache.get(N);
    }
}
