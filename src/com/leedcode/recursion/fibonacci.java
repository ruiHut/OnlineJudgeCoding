/**
 * fibonacci array: 1, 1, 2, 3, 5, 8, 13....
 * f(n) = f(n-1)  + f(n - 2)
 */

/** 
*  recursion bad solution example 
*  当递归产生重复子问题时，此时递归解决似乎不是最佳方案
*  比较好的解决方案是，保存（stack 保存）、判重
* 
*  递归经常在一些高级的算法中用到，例如分治。
*/
 class solition {
    public int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("error param: fibonacci less then 0。 n = ", n);

        if (n == 0 || n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
 }