package com.sam.bitree;

/**
 * @Author qiyunfei
 * @ClassName:TreeNode
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/5 10:23
 */
public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
