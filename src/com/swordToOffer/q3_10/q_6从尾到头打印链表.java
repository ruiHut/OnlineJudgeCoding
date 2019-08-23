package com.swordToOffer.q3_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: OnlineJudgeCoding
 * @description: 从尾到头反过来打印出每个结点的值。
 * @author: Mr.Zhou
 * @create: 2019-08-22 23:41
 **/

/**
 * solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%203~9.md#6-%E4%BB%8E%E5%B0%BE%E5%88%B0%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A8
 * 1. 递归
 * 2. 栈
 * 3. 头插法逆序链表
 */
public class q_6从尾到头打印链表 {

    // 递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode != null) {
            res.addAll(printListFromTailToHead(listNode.next));
            res.add(listNode.val);
        }

        return res;
    }
    public ArrayList<Integer> printListTailToHead(ListNode head) {
        if (head == null) return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>(printListTailToHead(head.next));
        res.add(head.val);
        return res;
    }

    // 栈

    public ArrayList<Integer> printListTailToHeadUseStack(ListNode head) {
        if (head == null) return new ArrayList<Integer>();

        Stack<Integer> temp = new Stack<Integer>();
        ListNode cur = head;
        while (cur != null) {
            temp.push(cur.val);
            cur = cur.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (temp.isEmpty()) {
            res.add(temp.pop());
        }

        return res;
    }

    // 反转栈
    public ArrayList<Integer> printfListTailToHeadReverseList(ListNode head) {
        if (head == null) return new ArrayList<>();

        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }

        head = dummy.next;
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res;
    }

    class ListNode {
        ListNode next;
        int val;
    }
}
