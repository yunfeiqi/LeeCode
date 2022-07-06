package com.sam.bitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:Mid
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/5 10:44
 */
public class Mid {
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

        traverse(root);

        for (Integer integer : order) {
            System.out.println(integer);
        }
    }

    public static void traverse(TreeNode root){
        if(root == null){
            return;
        }

        // Befor

        traverse(root.left);
        // Mid
        order.add(root.getValue());
        traverse(root.right);
        // after
    }
}
