·/**
 * 快速排序 QuickSort , 称 ：划分交换排序（partition-exchange sort) 
 * 在平均状况下，排序 n个项目要  O(n\log n)}（大O符号）次比较。
 * 在最坏状况下则需要 O(n^{2})次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地达成。 : 每一次交换都对最终结果有效
 * 
 * 实现： 
 *  快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为较小和较大的2个子序列，然后递归地排序两个子序列。
 *      1.  挑选基准值：从数列中挑出一个元素，称为“基准”（pivot），、
 *      2. 分割：重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一边）。
 *          在这个分割结束之后，对基准值的排序就已经完成，
 *      3. 递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列排序。
 *          递归终止条件：递归到最底部的判断条件是数列的大小是零或一，此时该数列显然已经有序。
 *      选取基准值有数种具体方法，此选取方法对排序的时间性能有决定性影响。
 * 伪代码： 
        *  function quicksort(q)
        {
            var list less, pivotList, greater
            if length(q) ≤ 1 
                return q
            else 
  ·          {
                select a pivot value pivot from q
                for each x in q except the pivot element
                {
                    if x < pivot then add x to less
                    if x ≥ pivot then add x to greater
                }
                add pivot to pivotList
                return concatenate(quicksort(less), pivotList, quicksort(greater))
            }
        }
    原地（in-place）分割的版本
        上面简单版本的缺点是，它需要(n)的额外存储空间，也就跟归并排序一样不好。额外需要的存储器空间配置，在实际上的实现，也会极度影响速度和缓存的性能。
        有一个比较复杂使用原地（in-place）分割算法的版本，且在好的基准选择上，平均可以达到 O(\log n)空间的使用复杂度。
     function partition(a, left, right, pivotIndex)
    {
        pivotValue = a[pivotIndex]
        swap(a[pivotIndex], a[right]) // 把pivot移到結尾
        storeIndex = left
        for i from left to right-1
        {
            if a[i] < pivotValue
            {
                swap(a[storeIndex], a[i])
                storeIndex = storeIndex + 1
            }
        }
        swap(a[right], a[storeIndex]) // 把pivot移到它最後的地方
        return storeIndex
    }

     procedure quicksort(a, left, right)
        if right > left
            select a pivot value a[pivotIndex]
            pivotNewIndex := partition(a, left, right, pivotIndex)
            quicksort(a, left, pivotNewIndex-1)
            quicksort(a, pivotNewIndex+1, right)
    
    优化的排序算法
        快速排序是二叉查找树（二叉搜索树）的一个空间最优化版本。（二叉查找树需要重新开辟一个数组，依次加入到二分搜索数中，然后中序遍历返回结果）
        快排也是进行比较，小于在左，大于在右。这两个算法完全地产生相同的比较次数，但是顺序不同
        对于排序算法的稳定性指标，原地分割版本的快速排序算法是不稳定的。其他变种是可以通过牺牲性能和空间来维护稳定性的。

    快速排序的最直接竞争者是堆排序（Heapsort）。
    堆排序通常比快速排序稍微慢，但是最坏情况的运行时间总是  O(n\log n)。快速排序是经常比较快，除了introsort变化版本外，仍然有最坏情况性能的机会。
    如果事先知道堆排序将会是需要使用的，那么直接地使用堆排序比等待introsort再切换到它还要快。
    堆排序也拥有重要的特点，仅使用固定额外的空间（堆排序是原地排序），而即使是最佳的快速排序变化版本也需要(log n)的空间。然而，堆排序需要有效率的随机存取才能变成可行。


    快速排序也与归并排序（Mergesort）竞争，这是另外一种递归排序算法，但有坏情况  O(n\log n)运行时间的优势。
    不像快速排序或堆排序，归并排序是一个稳定排序，且可以轻易地被采用在链表（linked list）和存储在慢速访问媒体上像是磁盘存储或网络连接存储的非常巨大数列。
    尽管快速排序可以被重新改写使用在链串列上，但是它通常会因为无法随机存取而导致差的基准选择。归并排序的主要缺点，是在最佳情况下需要 (n)额外的空间。

*/


class Solution {
    public static void QuickSort(int[] arr, int head, int tail) {
        // ending time: 待分割数组长度小于一。
        if (head >= tail || arr == null || arr.length <= 1) return;

        // partaion array
        int i = head, j = tail, pivot = arr[head + (tail - head) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        QuickSort(arr, head, j);
        QuickSort(arr, i, tail);
    }
}

class Solution {
    public static void QuickSort(int[] arr, int head, int tail) {
        // ending time: 待分割数组长度小于一。
        if (head >= tail || arr == null || arr.length <= 1) return;

        // partaion array
        int i = head, j = tail, pivot = arr[head + (tail - head) / 2];
        while(i <= j) {
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j++;
            if(i < j) {
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }

        QuickSort(arr, head, j);
        QuickSort(arr, i, tail);
    }
}