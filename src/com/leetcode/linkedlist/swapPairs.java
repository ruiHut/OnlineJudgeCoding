/*
 *1->2->3->4   
* 2->1->4->3
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode cur = pHead;
        while(head != null && head.next != null){
            ListNode next = head.next;
            head.next = next.next;
            cur.next = next;
            next.next = head;cur = head;
            head = head.next;
        }
        return pHead.next;
    }
}