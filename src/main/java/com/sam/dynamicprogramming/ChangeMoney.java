package com.sam.dynamicprogramming;

import java.util.HashMap;

/**
 * @Author qiyunfei
 * @ClassName:ChangeMoney
 * @Email: samqi1122@126.com
 * @Description: 凑零钱问题，Leecode332
 * @Date: 2022/7/6 11:49
 *
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 *
 * coins 中是可选硬币面值，amount 是目标金额
 * public static int coinChange(int[] coins, int amount)
 *
 * 最优子结构：
 * 假设你有面值为 1, 2, 5 的硬币，你想求 amount = 11 时的最少硬币数（原问题），
 * 如果你知道凑出 amount = 10, 9, 6 的最少硬币数（子问题），
 * 你只需要把子问题的答案加一（再选一枚面值为 1, 2, 5 的硬币），求个最小值，就是原问题的答案。
 * 因为硬币的数量是没有限制的，所以子问题之间没有相互制，是互相独立的。
 *
 * 动态规划要素：
 * base case： 这个很简单，显然目标金额 amount 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了
 * 确定「状态」（变化量），也就是原问题和子问题中会变化的变量：
 *      由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，
 *      所以唯一的「状态」就是目标金额 amount
 * 确定「选择」，也就是导致「状态」产生变化的行为：
 *      目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。
 *      所以说所有硬币的面值，就是你的「选择」。
 * 明确 dp 函数/数组的定义：
 *      一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。
 *      就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。
 */
public class ChangeMoney {

    private static HashMap<Integer,Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;

//        violence(coins,amount);

//        withCache(coins,amount);

        top2Lower(coins,amount);
    }

    public static void violence(int[] coins, int amount){
        long start = System.currentTimeMillis();
        int methodCount = f1(coins, amount);
        long end = System.currentTimeMillis();

        System.out.printf("暴力求解 耗时：%d,结果：%d",end - start,methodCount);

    }

    public static void withCache(int[] coins, int amount){
        long start = System.currentTimeMillis();
        int methodCount = f2(coins, amount);
        long end = System.currentTimeMillis();

        System.out.printf("带缓存 耗时：%d,结果：%d",end - start,methodCount);

    }

    public static void top2Lower(int[] coins, int amount){
        long start = System.currentTimeMillis();
        int methodCount = f3(coins, amount);
        long end = System.currentTimeMillis();

        System.out.printf("自底向上 耗时：%d,结果：%d",end - start,methodCount);

    }


    // 暴力递归
    public static int f1(int[] coins, int amount){
        // base case
        if(amount ==0) return 0;
        if(amount <0) return -1;

        // 额外变量
        int res = Integer.MAX_VALUE;

        // 选择，不同的选择下的硬币的数量
        for (int coin : coins) {
            // 选择当前coin后，子问题（amount - coin）的最优解
            int subProb = f1(coins, amount - coin);

            if(subProb  == -1){
                // 如果子问题无解，则继续下一种选择
                continue;
            }

            //选择子问题和当前问题的最小值
            res = Math.min(res, subProb + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // 备忘录模式
    public static int f2(int[] coins,int amount){
        // base case
        if(amount == 0) return 0;
        if(amount < 0) return  -1;

        int res = Integer.MAX_VALUE;
        // 选择,暴力 + 缓存
        for (int coin : coins) {
            // 子问题
            int subAmount = amount - coin;
            Integer subCount = cache.getOrDefault(subAmount, null);
            if(subCount == null){
                subCount = f2(coins, amount - coin);
                if(subCount ==-1){
                    continue;
                }
                cache.put(subAmount,subCount);
            }

            res = Math.min(res, subCount + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int f3(int[] coins,int amount){
        // base case
        cache.put(0,0);

        // 遍历所有的状态
        for (int state = 0; state <= amount; state++) {
            // 遍历所有的选择
            for (int coin : coins) {
                if(state - coin <0){
                    // 过滤不满足的情况
                    continue;
                }

                // 子问题处理公式
                cache.put(state,cache.get(state-coin) +1);
            }
        }
        return cache.get(amount);
    }


}
