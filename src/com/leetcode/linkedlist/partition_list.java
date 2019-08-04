/**
 * 86 solution
 * make two list union
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;

        before.next = afterHead.next;
        return beforeHead.next;
    }
}

