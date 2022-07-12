package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:DetectCycle
 * @Email: samqi1122@126.com
 * @Description: 如果单链表有环，请返回环的开始位置
 * @Date: 2022/7/12 11:17
 *
 * 1. 首先检查链表是否有环 {@link com.sam.link.HasCycle}
 * 2. 如果有，则返回位置
 *
 * 当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
 * 我们假设快慢指针相遇时，慢指针slow走了k步，那么快指针fast一定走了2k步：
 * fast一定比slow多走了k步，这多走的k步其实就是fast指针在环里转圈圈，所以k的值就是环长度的「整数倍」。
 *
 * 假设相遇点距环的起点的距离为m，那么结合 slow 指针，环的起点距头结点head的距离为k - m，
 * 也就是说如果从head前进k - m步就能到达环起点。
 * 巧的是，如果从相遇点继续前进k - m步，也恰好到达环起点。因为结合 fast 指针，从相遇点开始走k步可以转回到相遇点，
 * 那走k - m步肯定就走到环起点了：
 * 所以，只要我们把快慢指针中的任一个重新指向head，然后两个指针同速前进，k - m步后一定会相遇，相遇之处就是环的起点了。
 */
public class DetectCycle {

    public static ListNode detectCycle(ListNode head){
        // 快慢指针
        ListNode fast,slow ;
        fast = slow = head;

        while (fast != null  && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            // 有环
            if(fast == slow) break;
        }

        // 没有环
        if(fast == null || fast.getNext() == null){
            return null;
        }

        //让 slow 从头走，fast和slow 以相同速度走，再次相遇时就是环的开始
        slow = head;
        while (slow != fast){
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return  slow;
    }
}
