package com.swordToOffer.q10_19;

import java.util.List;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#181-%E5%9C%A8-o1-%E6%97%B6%E9%97%B4%E5%86%85%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E8%8A%82%E7%82%B9
public class q_18_1删除单链表节点 {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return head;

        if (tobeDelete.next != null && tobeDelete != head) {
            // 待删除节点不为尾结点, 且该节点不为 head 节点
            tobeDelete.var = tobeDelete.next.var;
            tobeDelete.next = tobeDelete.next.next;
        } else {
            if (tobeDelete == head) {
                //  待删除节点为头结点，且仅有一个节点
                head = null;
            } else {
                // 待删除节点为最后一个节点，且不为头结点
                ListNode cur = head;
                while (cur.next != tobeDelete) {
                    cur = cur.next;
                }
                cur.next = null;

                // tobe == null 不行, 这仅仅是将引用设置为空
            }
        }
        return head;
    }
}

class ListNode {
    ListNode next;
    int var;
}

/* 为什么时间复杂度为 O(1) ？

    1. 不是尾结点 时间为 O(1)
    2. 否则 O(N)
    综上，如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1，其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度操作节点的总次数，
    N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。(2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。
 */

