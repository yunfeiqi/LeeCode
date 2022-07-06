package com.sam.bitree;

/**
 * @Author qiyunfei
 * @ClassName:PrintSubTreeSize
 * @Email: samqi1122@126.com
 * @Description: 打印左右子树各有多少节点
 * @Date: 2022/7/5 22:53
 */
public class PrintSubTreeSize {
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

    }

    /**
     * 如何打印出每个节点的左右子树各有多少节点？
     * 只有后序位置才能通过返回值获取子树的信息
     * 一旦发现题目和子树有关，那大概率要给函数设置合理的定义和返回值，在后序位置写代码了。
     * @param root
     */
    public static int traverse(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSize = traverse(root.left);
        int rightSize = traverse(root.right);

        // 后序位置
        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点\n",
                root, leftSize, rightSize);
        return leftSize + rightSize + 1;
    }

}
