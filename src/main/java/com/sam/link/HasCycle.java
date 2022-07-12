package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:hasCycle
 * @Email: samqi1122@126.com
 * @Description: 判断链表是否有环
 * @Date: 2022/7/12 11:10
 *
 * 判断单链表是否包含环属于经典问题了，解决方案也是用快慢指针
 * 每当慢指针slow前进一步，快指针fast就前进两步。
 * 如果fast最终遇到空指针，说明链表中没有环；如果fast最终和slow相遇，那肯定是fast超过了slow一圈，说明链表中含有环。
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null ){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast == slow) break;
        }

        return fast == null? false:true;
    }
}
