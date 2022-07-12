package com.sam.link;

/**
 * @Author qiyunfei
 * @ClassName:ListNode
 * @Email: samqi1122@126.com
 * @Description:
 * @Date: 2022/7/8 17:09
 */
public class ListNode {

    private int value;
    private ListNode next;


    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
