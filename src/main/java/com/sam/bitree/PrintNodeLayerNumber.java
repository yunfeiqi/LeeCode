package com.sam.bitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:PrintNodeLayerNumber
 * @Email: samqi1122@126.com
 * @Description: 打印二叉树每个节点的层数，root的层数=1
 * @Date: 2022/7/5 22:47
 *
 * 如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
 */
public class PrintNodeLayerNumber {

    static int deep = 1;
    static List<Integer> order = new ArrayList<>();

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

        traverse(root,1);

        for (Integer integer : order) {
            System.out.println(integer);
        }

    }

    public static void traverse(TreeNode root,int level){
        if(root == null){
            return;
        }

        // 前序位置
        System.out.printf("节点 %s 在第 %d 层\n", root, level);
        traverse(root.left,level +1);
        traverse(root.right,level +1);

    }

}
