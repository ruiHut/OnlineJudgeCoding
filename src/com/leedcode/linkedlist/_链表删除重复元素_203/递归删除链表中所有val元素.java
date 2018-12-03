package com.leedcode.linkedlist._链表删除重复元素_203;

/**
 * @program: LeedCode
 * @description: 203
 * @author: Mr.Zhou
 * @create: 2018-11-22 10:45
 **/

public class 递归删除链表中所有val元素 {
}

 class Solution2 {
     public static void main(String[] args) {
//         int[] nums = {1, 2, 3, 4 ,5 ,1 ,2 ,1 };
//         ListNode head = new ListNode(nums);
//         System.out.println(head);
//
//         ListNode headS = new Solution2().removeElements(head ,1);
//         System.out.println(head);

     }
    public ListNode removeElements(ListNode head , int val){

        /**
         * 递归实现
         */
        if (head == null)
            return null;
        head.next = removeElements(head.next , val);
        return head.val ==  val ? head.next :head;

//        if (head == null) return head;
//        // 设置虚拟头节点
//        ListNode dummy = new ListNode(-1) , prev = dummy;
//        dummy.next = head;
//        while (head != null) {
//
//            // 如果相同就删除元素 head
//            if (head.val == val) {
//                prev.next = head.next;
//                head=head.next;
//                continue;
//            }
//            // 如果不相同就跳过元素 head+1
//            head = head.next;
//            prev = prev.next;
//        }
//
//        return dummy.next;
    }


}

 class ListNode2 {
    int[] val ;
    ListNode2 next;
    ListNode2(int[] x ){
        val = x ;
    }
}