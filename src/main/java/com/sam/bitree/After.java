package com.sam.bitree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:After
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/5 10:48
 */
public class After {

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

//        traverse(root);
        order =  traverse2(root);

        for (Integer integer : order) {
            System.out.println(integer);
        }

    }

    public static void traverse(TreeNode node){
        if(node == null){
            return;
        }

        traverse(node.left);

        traverse(node.right);

        order.add(node.getValue());
    }

    /**
     * 采用分治的策略，通过子树
     * 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
     * @param root
     */
    public static List<Integer> traverse2(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }


        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(traverse2(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(traverse2(root.right));

        // 后序遍历的结果，root.val 在第一个
        res.add(root.getValue());


        return  res;
    }
}
