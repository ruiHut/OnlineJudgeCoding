/**
 * 归并排序： 分治法 无序 ->  部分有序  ->  整体有序
 *   优缺点：
 *      归并排序的效率达到了巅峰：时间复杂度为O(nlogn)，这是基于比较的排序算法所能达到的最高境界
 *      归并排序是一种稳定的算法（即在排序过程中大小相同的元素能够保持排序前的顺序，3212升序排序结果是1223，排序前后两个2的顺序不变），这一点在某些场景下至关重要
 *      归并排序是最常用的外部排序方法（当待排序的记录放在外存上，内存装不下全部数据时，归并排序仍然适用，当然归并排序同样适用于内部排序…）
 *
 *      归并排序需要O(n)的辅助空间，而与之效率相同的快排和堆排分别需要O(logn)和O(1)的辅助空间，在同类算法中归并排序的空间复杂度略高
 *
 *   应用场景：
 *   归并排序多用于需要外部排序的场景，除此之外当内部排序需要保证稳定性时也采用归并排序（不要求稳定性的内部排序一般采用快排或者堆排序，前者在待排序序列基本有序时效率低，后者堆的维护是个问题）
 *
 */

// 数组实现归并排序
class Solution2 {
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // merge sort need allocation temp array
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if ()
        }
    }
}


 // 单链表归并排序
 class Solution {
     public ListNode mergeSort(ListNode head) {
         if (head == null || head.next == null) return head;

         ListNode slow = head, fast = head, pre = null;
         while (fast != null && fast.next != null) {
             pre = slow;
             slow = slow.next;
             fast = fast.next.next;
         }
         // split list
         pre.next = null;
         ListNode left = mergeSort(head), right = mergeSort(slow);
         return  merge(left, right);
     }

     private  ListNode merge(ListNode left, ListNode right) {
         if (left == null || right == null) return left == null? right : left;
         ListNode dummy = new ListNode(Integer.MIN_VALUE), cur = dummy;
         while (left != null && right != null) {
             if (left.val <= right.val) {
                 cur.next = left;
                 left = left.next;
             } else {
                 cur.next = right;
                 right = right.next;
             }
             cur = cur.next;
         }
         cur.next = left == null ? right : left;
         return dummy.next;
     }
 }

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}