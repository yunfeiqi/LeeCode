package com.sam.bitree;

/**
 * @Author qiyunfei
 * @ClassName:Befor
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/5 10:23
 */
public class Template {

    public void traverse(TreeNode root){
        // 递归终止条件
        if(root == null){
            return;
        }

        // 前序位置
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
    }
}
