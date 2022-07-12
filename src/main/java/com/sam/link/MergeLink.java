package com.sam.link;

import java.util.List;

/**
 * @Author qiyunfei
 * @ClassName:MergeLink
 * @Email: samqi1122@126.com
 * @Description: 合并链表 Leecode 21
 * @Date: 2022/7/8 17:08
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定
 * 的两个链表的所有节点组成的。
 *
 * ListNode mergeTwoLists(ListNode l1, ListNode l2);
 */
public class MergeLink {

    public static void main(String[] args) {
        ListNode f1 = new ListNode();
        f1.setValue(1);
        ListNode f2 = new ListNode();
        f2.setValue(2);
        ListNode f3 = new ListNode();
        f3.setValue(4);

        f1.setNext(f2);
        f2.setNext(f3);

        ListNode a1 = new ListNode();
        a1.setValue(1);
        ListNode a2 = new ListNode();
        a2.setValue(3);
        ListNode a3 = new ListNode();
        a3.setValue(4);

        a1.setNext(a2);
        a2.setNext(a3);


        ListNode listNode = mergeTwoLists(f1, a1);

        while (listNode != null){
            System.out.printf("%d,",listNode.getValue());
            listNode = listNode.getNext();
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        head.setValue(-1);
        ListNode p = head;

        while (l1!=null && l2!=null){
            if(l1.getValue() <l2.getValue()){
                p.setNext(new ListNode(l1.getValue()));
                l1 = l1.getNext();
            }else{
                p.setNext(new ListNode(l2.getValue()));
                l2 = l2.getNext();
            }

            p = p.getNext();
        }

        if(l1!= null){
            p.setNext(l1);
        }

        if(l2 != null){
            p.setNext(l2);
        }

        return head;
    }
}
