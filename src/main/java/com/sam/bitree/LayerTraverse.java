package com.sam.bitree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author qiyunfei
 * @ClassName:LayerTraverse
 * @Email: samqi1122@126.com
 * @Description: 层序遍历
 * @Date: 2022/7/5 23:26
 */
public class LayerTraverse {
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

        layerTraverse(root);
    }

    public static void layerTraverse(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                System.out.println(currNode.getValue());
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }

                if(currNode.right != null){
                    queue.offer(currNode.right);
                }

            }
        }

    }
}
