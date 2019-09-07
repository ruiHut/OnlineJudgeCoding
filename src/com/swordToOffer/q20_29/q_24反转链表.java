package com.swordToOffer.q20_29;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2020~29.md#24-%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8
public class q_24反转链表 {

    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(); // dummy.next is prev node
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }

        return dummy.next;
    }
}
