package com.sam.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author qiyunfei
 * @ClassName:OpenPWLock
 * @Email: samqi1122@126.com
 * @Description: 打开密码锁，Leecode 752
 * @Date: 2022/7/7 08:48
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字：0,1,...,9
 * 每个拨轮可以自由旋转：例如把9"变为"0"
 * 转都只能旋转一个拨轮的一位数宇。
 * 锁的初始数字为"0000‘
 * 列表deadends包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 宇符串target代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回-1。
 */
public class OpenPWLock {

    static int ringNum = 4;

    public static void main(String[] args) {
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};

        int bfs = bfs(deadends, "0202");
        System.out.println(bfs);
    }

    /**
     * 对 j 位置的转盘 向上 转动
     * @param p
     * @param j
     * @return
     */
    public static String up(String p,int j){
        char[] chars = p.toCharArray();
        if(chars[j] == '9'){
            chars[j] = '0';
        }

        chars[j] += 1;
        return new String(chars);
    }

    /**
     * 对 j 位置的转盘 向下 转动
     * @param p
     * @param j
     * @return
     */
    public static String down(String p,int j){
        char[] chars = p.toCharArray();
        if(chars[j] =='0'){
            chars[j] ='9';
        }

        chars[j] -=1;

        return new String(chars);
    }

    public static int bfs(String[] deadends, String target){
        // 把死亡密码 放到 已访问的队列中
        Set<String> visit= new HashSet<>();
        for (String deadend : deadends) {
            visit.add(deadend);
        }

        // 定义队列
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visit.add("0000");

        // 定义步长
        int step = 0;

        // 开始遍历队列
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                // 队列中取出
                String curr = queue.poll();

                // 判断是否结束
                if(curr.equals(target)){
                    return step;
                }

                // 找到下一层节点
                for (int j = 0; j < ringNum; j++) {
                    String up = up(curr, j);
                    if(!visit.contains(up)){
                        queue.offer(up);
                        visit.add(up);
                    }


                    String down = down(curr, j);
                    if(!visit.contains(down)){
                        queue.offer(down);
                        visit.add(down);
                    }

                }
            }

            // 步长 +1
            step ++;
        }

        // 没有找到密码，返回-1
        return -1;
    }
}
