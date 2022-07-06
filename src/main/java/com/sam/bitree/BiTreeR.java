package com.sam.bitree;

/**
 * @Author qiyunfei
 * @ClassName:BiTreeR
 * @Email: samqi1122@126.com
 * @Description: 二叉树的直径：计算一棵二叉树的最长直径长度。
 * @Date: 2022/7/5 23:00
 *
 * 二叉树的「直径」长度，就是任意两个结点之间的路径长度。最长「直径」并不一定要穿过根结点，
 * 解决这题的关键在于，每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
 */
public class BiTreeR {
    public static int maxR = 0;
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

//        method1(root);
        method2(root);

        System.out.println(maxR);

    }

    /**
     * 遍历二叉树，计算每一个节点的最大深度
     *
     * 方法1：前序方法
     * @param root
     */
    public static void method1(TreeNode root){
        if(root == null){
            return;
        }

        int leftMaxDeep = maxDeep(root.left);
        int rightMaxDeep = maxDeep(root.right);
        // 最大直径就是:左右子树的最大深度之和
        int r = leftMaxDeep + rightMaxDeep;
        // 更新最大深度
        maxR = Math.max(r,maxR);

        method1(root.left);
        method1(root.right);
    }

    /**
     * 前序方法无法获得子树结果，所以采用后序方法
     * 遇到子树问题，首先想到的是给函数设置返回值，然后在后序位置做文章
     * @param root
     */
    public static int method2(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDeep = method2(root.left);
        int rightDeep = method2(root.right);

        // 计算当前节点的最大直径
        int tmpR =  leftDeep + rightDeep;
        // 更新全局最大直径
        maxR = Math.max(maxR,tmpR);

        return Math.max( leftDeep , rightDeep) + 1;

    }

    /**
     * 计算二叉树的最大深度
     * @param root
     * @return
     */
    public static int maxDeep(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);
        return  Math.max(leftDeep , rightDeep) + 1;

    }

}
