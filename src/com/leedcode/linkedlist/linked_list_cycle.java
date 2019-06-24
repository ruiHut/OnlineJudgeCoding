import java.util.Set;

/*
* 单链表判断是否成环
    1. 硬做
    2. set 存对象地址
    3. 快，慢指针 
    // 面试尽量将所有解决方案都讲出来，对比分析
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) 
            return false;

        ListNode fast = head, slow = head;
        while(fast != null && slow != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) 
                return true;
        }
        return false;
    }

    public boolean hash(ListNode head) {
        if (head == null || head.next == null) 
            return false;

        Set<E> nodeSet = new HashSet();
        while(head != null)
        {
           if (nodeSet.contains(head)) 
            return true;
           else

            head = head.next;
        }
        return false;
    }
}