package com.swordToOffer.q10_19;


// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#17-%E6%89%93%E5%8D%B0%E4%BB%8E-1-%E5%88%B0%E6%9C%80%E5%A4%A7%E7%9A%84-n-%E4%BD%8D%E6%95%B0
// 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
public class q_17打印从1到最大的n位数 {
    public static void main(String[] args) {
        q_17打印从1到最大的n位数 q = new q_17打印从1到最大的n位数();
        q.print1ToMaxOfNDigits(3);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }


}
