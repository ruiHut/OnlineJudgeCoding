package com.swordToOffer.q20_29;

import javax.swing.*;

// solution： https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2020~29.md#23-%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%8E%AF%E7%9A%84%E5%85%A5%E5%8F%A3%E7%BB%93%E7%82%B9
// desc: 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
public class q_23链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head, low = head;
        do {
            fast = fast.next.next;
            low = low.next;
        } while (fast != low);

        fast = head;
        while (fast != low) {
            low = low.next;
            fast = fast.next;
        }

        return fast;
    }
}
