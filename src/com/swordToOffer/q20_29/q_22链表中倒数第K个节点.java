package com.swordToOffer.q20_29;


// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2020~29.md#22-%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC-k-%E4%B8%AA%E7%BB%93%E7%82%B9
public class q_22链表中倒数第K个节点 {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode p1 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        if (k > 0)
            return null;

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}

class ListNode {
    ListNode next;
    int var;
}
