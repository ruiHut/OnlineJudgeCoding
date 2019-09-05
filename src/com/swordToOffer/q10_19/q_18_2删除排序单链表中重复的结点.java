package com.swordToOffer.q10_19;

import java.util.HashSet;
import java.util.Set;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#182-%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E7%BB%93%E7%82%B9
public class q_18_2删除排序单链表中重复的结点 {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null)
             return head;

        ListNode pNext = head.next;
        if (pNext.var == head.var) {
            while (pNext != null && head.var == pNext.var)
                pNext = pNext.next;
            return deleteDuplication(pNext);
        } else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }
}
