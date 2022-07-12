package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:IntersectionNode
 * @Email: samqi1122@126.com
 * @Description: 两个链表相交
 * @Date: 2022/7/12 11:30
 *
 * 给你输入两个链表的头结点headA和headB，这两个链表可能存在相交。
 * 如果相交，你的算法应该返回相交的那个节点；如果没相交，则返回 null。
 *
 * 双指针难点：
 *  用两个指针p1和p2分别在两条链表上前进，并不能同时走到公共节点，也就无法得到相交节点c1
 *
 * 所以，解决这个问题的关键是，通过某些方式，让p1和p2能够同时到达相交节点c1。
 * 我们可以让p1遍历完链表A之后开始遍历链表B，让p2遍历完链表B之后开始遍历链表A，这样相当于「逻辑上」两条链表接在了一起。
 * 如果这样进行拼接，就可以让p1和p2同时进入公共部分，也就是同时到达相交节点c1：
 */
public class IntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // 定义两个指针
        ListNode p1,p2;
        p1 = headA;
        p2 = headB;

        while (p1 != p2){
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if(p1 == null){
                p1= headB;
            }else {
                p1 = p1.getNext();
            }

            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if(p2 == null){
                p2 = headA;
            }else {
                p2 = p2.getNext();
            }
        }

        return  p1;
    }
}
