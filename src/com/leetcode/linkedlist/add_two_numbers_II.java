/**
 * 445 add two numbers II
 * 1. reversing the list
 * 2. stack or recursion
 */

// reversion the list
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // reverse the list
        ListNode pre1 = null;
        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = pre1;
            pre1 = l1;
            l1 = temp;
        }
        ListNode pre2 = null;
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = pre2;
            pre2 = l2;
            l2 = temp;
        }
        l1 = pre1;
        l2 = pre2;

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0){
            res.next = new ListNode(carry);
        }

        // reverse the result
        ListNode preDummy = null;
        ListNode head = dummy.next;
        while (head != null) {
            ListNode temp = head.next;
            head.next = preDummy;
            preDummy = head;
            head = temp;
        }
        return preDummy;
    }
}

// recursion
class Solution {
    ListNode node;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode p = l1;
        while (p != null){
            len1++;
            p = p.next;
        }
        p = l2;
        while (p != null){
            len2++;
            p = p.next;
        }

        int carry;
        if (len1 > len2){
            carry = sumLists(l1, len1, l2, len2);
        } else {
            carry = sumLists(l2, len2, l1, len1);
        }
        if (carry > 0){
            ListNode curr = new ListNode(carry);
            curr.next = node;
            node = curr;
        }
        return node;
    }

    int sumLists(ListNode listLong, int lenLong, ListNode listShort, int lenShort){
        if (listShort == null){
            return 0;
        }

        int carry;
        int val;
        if (lenLong - lenShort > 0){
            carry = sumLists(listLong.next, lenLong-1, listShort, lenShort);
            val = (listLong.val + carry)%10;
            carry = (listLong.val + carry)/10;

        } else {
            carry = sumLists(listLong.next, lenLong-1, listShort.next, lenShort-1);
            val = (listLong.val + listShort.val + carry)%10;
            carry = (listLong.val + listShort.val + carry)/10;
        }

        ListNode curr = new ListNode(val);
        curr.next = node;
        node = curr;
        return carry;

    }
}