/**
 * 61 rotate list
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode endNode = head;
        while (endNode.next != null) {
            endNode = endNode.next;
            len++;
        }
        endNode.next = head;

        int moveTime = len - k % len;
        while (moveTime-- != 0) {
            endNode = head;
            head = head.next;
        }
        endNode.next = null;

        return head;
    }
}