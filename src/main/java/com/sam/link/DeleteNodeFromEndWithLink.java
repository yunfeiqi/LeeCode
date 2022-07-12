package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:DeleteNodeFromEndWithLink
 * @Email: samqi1122@126.com
 * @Description: 删除链表倒数第K个元素, Leecode 19
 * @Date: 2022/7/12 10:49
 */
public class DeleteNodeFromEndWithLink {

    /**
     * 要删除倒数第n个节点，就得获得倒数第n + 1个节点的引用，
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head,int k){
        ListNode dummy = new ListNode(-1);
        dummy.setNext(head);

        // 需要找到倒数第 k + 1 个元素
        ListNode targetNode = findValueFromEnd(dummy, k+1);
        if(targetNode == null) return head;

        // 第 K 个元素
        ListNode nodeK = targetNode.getNext();
        if(nodeK== null) return head;

        // 从链表中删除第K个元素
        targetNode.setNext(nodeK.getNext());
        return dummy.getNext();

    }

    /**
     * 从链表末尾找到第K个元素，详情请参考 {@link com.sam.link.LinkKValueFromTail}
     * @param head
     * @param k
     * @return
     */
    public static ListNode findValueFromEnd(ListNode head,int k){
        if(head == null)  return null;

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.getNext();
        }

        while (p1 != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return  p2;
    }
}
