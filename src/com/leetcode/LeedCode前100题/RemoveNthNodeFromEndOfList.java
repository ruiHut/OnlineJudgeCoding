/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * solution
 * 1. two pass algorithm  O(N)      (remove the node is Len - n + 1)
 * 2. one pass algorithm  O(Len - n)
 */

// 1. two pass algorithm
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while(first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while(length > 0) {
            length--;
            first = first.next;
        }
        // remove target node
        first.next = first.next.next;

        return dummy.next; // remove dummyNode
    }
}

// one pass algorithm O(L - n)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;

        // make pre index to the (Len - n + 1)
        for (int i = 0; i < n; i++) pre = pre.next;

        while (pre != null) {
            pre = pre.next;
            cur = cur.next;
        }
        // remove target node
        cur.next = cur.next.next;
        return dummy.next;
    }
}