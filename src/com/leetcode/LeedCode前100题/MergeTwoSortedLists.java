/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // this two situation contain when l1 == null and l2 == null
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(1);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode resHead = dummy;
        while(head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                resHead.next = head2;
                head2 = head2.next;
            } else {
                resHead.next = head1;
                head1 = head1.next;
            }
            resHead = resHead.next;
        }

        if (head1 == null) {
            resHead.next = head2;
        } else {
            resHead.next = head1;
        }
        return dummy.next;
    }
}