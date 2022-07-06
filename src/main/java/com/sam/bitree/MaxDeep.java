package com.sam.bitree;

/**
 * @Author qiyunfei
 * @ClassName:MaxDeep
 * @Email: samqi1122@126.com
 * @Description: 返回二叉树的最大深度
 * @Date: 2022/7/5 22:15
 */
public class MaxDeep {
    static int maxDeep = 0;
    static int treeDeep = 0;


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
        maxDeep = traverse2(root);

        System.out.println(maxDeep);
    }

    public static void traverse(TreeNode root){
        if(root == null){
            return;
        }

        // 前序
        treeDeep++;
        maxDeep = Math.max(maxDeep,treeDeep);
        traverse(root.left);
        traverse(root.right);
        --treeDeep;
    }

    /**
     * 思路2：采用分治的方法
     * @param root
     */
    public static int traverse2(TreeNode root){
        if(root == null){
            return 0;
        }
        // 二叉树的最大深度等于：左子树的深度和右子树深度的最大值 +1 （Root）
        int leftDeep = traverse2(root.left);
        int rightDeep = traverse2(root.right);
        return Math.max(leftDeep,rightDeep) +1;
    }
}
