/**
 * 148 sort list
 */

class Solution {//mine
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head), right = sortList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) return left == null ? right : left;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null || right != null) {
            if (right == null || (left != null && left.val <= right.val)) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}