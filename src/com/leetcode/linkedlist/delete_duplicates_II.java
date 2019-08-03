class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur != null && cur.val == cur.next.val)
                    cur = cur.next;
                cur = cur.next;
            } else {
                // move two node;
                dummy.next = cur;
                dummy = cur;
                cur = cur.next;
            }
        }
        if (cur == null)
            dummy.next = null;
        else
            dummy.next = cur;

        return  res.next;
    }
}