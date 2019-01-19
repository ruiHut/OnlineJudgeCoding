package leedcode.LeedCode前100题;

import java.util.List;

/**
 * @program: LeedCode3
 * @description: 添加两个数字
 * @author: Mr.Zhou
 * @create: 2019-01-19 17:09
 **/

public class AddTwoNumbers {
    public static void main(String[] args) {

    }
}

class Solution_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(1);
        L1.next = new ListNode(8);
        L1.next = new ListNode(9);

        ListNode L2 = new ListNode(9);
        L2.next = new ListNode(8);
        L2.next = new ListNode(5);

        ListNode res = addTwoNumbers(L1 ,L2);
    }
    /**
     * 将传入链表逆序返回
     * 例如 input 1 -> 2
     * return 2 -> 1
     *
     * @param listNode
     * @return
     */
    public static ListNode negativeListNode(ListNode listNode) {
        if (listNode.next == null)
            return listNode;
        ListNode nextNode = listNode.next;
        listNode.next = null;
        ListNode before = listNode;
        while (nextNode != null) {
            ListNode cur = nextNode;
            nextNode = nextNode.next;
            cur.next = before;
            before = cur;
        }
        return before;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


