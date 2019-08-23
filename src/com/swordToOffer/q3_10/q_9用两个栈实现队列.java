package com.swordToOffer.q3_10;

import java.util.Stack;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-23 14:32
 **/

public class q_9用两个栈实现队列 {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        while (out.isEmpty())
            if (in.isEmpty())
                throw new Exception("queue is empty");
            else
                while (!in.isEmpty())
                    out.push(in.pop());

        return out.pop();
    }

    //  another pop way
    // public int pop() throws Exception {
    //    if (out.isEmpty())
    //        while (!in.isEmpty())
    //            out.push(in.pop());
    //
    //    if (out.isEmpty())
    //        throw new Exception("queue is empty");
    //
    //    return out.pop();
    //}
}
