package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:LinkMiddleNode
 * @Email: samqi1122@126.com
 * @Description: 链表的中点，Leecode 876
 * @Date: 2022/7/12 11:05
 *
 * 链表的中间结点，问题的关键也在于我们无法直接得到单链表的长度n，常规方法也是先遍历链表计算n，再遍历一次得到第n / 2个节点，
 * 也就是中间节点。如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧。
 */
public class LinkMiddleNode {


    public static ListNode middleNode(ListNode head){
        if(head == null) return null;
        //初始化快慢指针，快指针比慢指针速度快一倍

        // 每步走两个节点
        ListNode fast = head;
        // 每步走一个节点
        ListNode slow = head;

        // 当快指针到达终点时，慢指针刚好到达一半
        while (fast != null){
            // 慢指针走一步，快指针走两步
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        // 慢指针指向中点
        return  slow;
    }
}
