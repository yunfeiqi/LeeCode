package com.sam.link;

import java.util.PriorityQueue;

/**
 * @Author qiyunfei
 * @ClassName:MergeKUpLink
 * @Email: samqi1122@126.com
 * @Description: 合并K个升序链表
 * @Date: 2022/7/8 17:24
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKUpLink {

    /**
     * 该题的逻辑不复杂，难点在于如何从多个链表中快速找到最小值，
     * 其实就是一个排序问题，从N个数中找出最小值，可以借助堆排序（小根堆）
     * @param lists
     * @return
     */
   public static ListNode mergeKLists(ListNode[] lists){
       if(lists == null || lists.length <=0) return null;
       ListNode head = new ListNode();
       ListNode pointer = head;

       // 优先级队列，其实就是一个堆
       PriorityQueue<ListNode> queue = new PriorityQueue<>(
               lists.length,
               (a,b) -> a.getValue() - b.getValue()
       );

       // 利用小根堆 把链表中每个元素插入到小根堆
       for (ListNode kHead : lists) {
           if(kHead != null){
                queue.add(kHead);
           }
       }

       // 从小根堆中取出头节点（最小值）
       while (!queue.isEmpty()){
           ListNode minNode = queue.poll();
           pointer.setNext(new ListNode(minNode.getValue()));
           pointer = pointer.getNext();

           // 继续向小根堆中添加元素
           ListNode next = minNode.getNext();
           if(next != null){
               queue.add(next);
           }
       }

       return head;
   }
}
