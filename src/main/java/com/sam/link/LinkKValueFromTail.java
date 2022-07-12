package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:LinkKValueFromTail
 * @Email: samqi1122@126.com
 * @Description: 单链条倒数第K个值
 * @Date: 2022/7/12 10:37
 *
 * 单链表的倒数第 k 个节点，
 * 假设链表有n个节点，倒数第k个节点就是正数第n - k个节点，
 * 但是算法题一般只给你一个ListNode头结点代表一条单链表，你不能直接得出这条链表的长度n，
 * 而需要先遍历一遍链表算出n的值，然后再遍历链表计算第n - k个节点，
 * 也就是说，这个解法需要遍历两次链表才能得到出倒数第k个节点。
 *
 * 我们能不能只遍历一次链表，就算出倒数第k个节点？
 */
public class LinkKValueFromTail {

    /**
     * 首先，我们先让一个指针p1指向链表的头节点head，然后走k步，
     * 现在的p1，只要再走n - k步，就能走到链表末尾的空指针了对吧？
     * 趁这个时候，再用一个指针p2指向链表头节点head，
     * 接下来就很显然了，让p1和p2同时向前走，p1走到链表末尾的空指针时走了n - k步，p2也走了n - k步，
     * 也就恰好到达了链表的倒数第k个节点。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode findFromEnd(ListNode head,int k){
        ListNode p1 = head;
        ListNode p2 = head;


        // 先让p1 移动 K步
        for (int i = 0; i < k && p1 != null; i++) {
            p1 = p1.getNext();
        }

        // 检查如果此时p1 = null 则直接返回
        if(p1 == null){
            return null;
        }

        // 让p2 和p1 同时再向前走 n-k 步骤，此时p2就是倒是k的位置
        while (p1 != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p2;


    }
}
