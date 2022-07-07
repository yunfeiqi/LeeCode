package com.sam.bfs;

import com.sam.bitree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author qiyunfei
 * @ClassName:MinPath
 * @Email: samqi1122@126.com
 * @Description: 二叉树的最小路径, Leecode 111
 * @Date: 2022/7/7 08:31
 *
 * 明确开始和结束节点
 */
public class MinPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setValue(0);

        TreeNode l1 = new TreeNode();
        l1.setValue(1);

        TreeNode l2 = new TreeNode();
        l2.setValue(2);

        TreeNode l3 = new TreeNode();
        l3.setValue(3);

        TreeNode l4 = new TreeNode();
        l4.setValue(4);

        l1.setLeft(l3);
        l1.setRight(l4);

        root.setLeft(l1);
        root.setRight(l2);

        int depth = minDepth(root);

        System.out.println(depth);
    }

    public static int minDepth(TreeNode root){
        // 特殊处理
        if(root == null) return 0;

        // 定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 定义步长
        int step = 0 ;

        // 项队列添加原始root
        queue.offer(root);
        step = 1;

        while (!queue.isEmpty()){
            int sz = queue.size();

            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                // 取出队列中的节点
                TreeNode current = queue.poll();
                // 判断当前节点是否已经到达终点
                if(current.left == null && current.right == null){
                    return step;
                }

                // 未达到终点，则继续向下扩散
                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            // 步数加1
            step ++ ;
        }

        return  step;
    }

}
