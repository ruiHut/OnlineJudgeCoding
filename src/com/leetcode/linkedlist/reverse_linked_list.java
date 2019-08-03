/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null ) // 少于两个节点无需反转
            return head;
        
        // ListNode temp; temp 在此处定义却未使用不干净
        ListNode prev = head;
        ListNode cur  = head.next;
        head.next = null;
        while(cur)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // recursive assume you just have two node 1 -> 2
    public  ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

public class ListNode {
    int var;
    ListNode next;
    ListNode(int x) {var = x;}
}