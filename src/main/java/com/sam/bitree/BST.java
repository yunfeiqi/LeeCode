package com.sam.bitree;

/**
 * @Author qiyunfei
 * @ClassName:BST
 * @Email: samqi1122@126.com
 * @Description: 宽度优先遍历
 * @Date: 2022/7/5 23:21
 */
public class BST {

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
    }
}
