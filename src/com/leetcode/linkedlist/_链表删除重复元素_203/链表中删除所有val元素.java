package leedcode.linkedlist._链表删除重复元素_203;

/**
 * @program: LeedCode
 * @description: 203
 * @author: Mr.Zhou
 * @create: 2018-11-22 10:45
 **/

public class 链表中删除所有val元素 {
}

class Solution {
    public ListNode removeElements(ListNode head , int val){

        // 删除开始部分的节点 即 头节点
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head ;
        while(prev.next != null){
            if (prev.next.val == val){
                ListNode delNodo = prev.next;
                prev.next = delNodo.next;
                delNodo.next = null;
            }
            else
                prev = prev.next;
        }
        return head;
    }
    private class ListNode {
        int val ;
        ListNode next;
        ListNode(int x ){
            val = x ;
        }
    }
}

