/**
 * 328 odd even Linked list
 * two list save odd 、 even list to union
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // oddList add odd node
            odd.next = even.next;
            odd = odd.next;
            // evenList add even node
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}