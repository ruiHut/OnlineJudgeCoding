package BasicAlgorithmImpl.sort;

/**
 * @program: LeedCode3
 * @description: 插入排序
 * @author: Mr.Zhou
 * @create: 2019-01-15 15:29
 **/

/**
 * 插入排序实际时间和数据状况有关
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] before = new int[]{1, 5, 2, 3, 6, 7, 2};
        int[] after = InsertSort.sort(before);
        for (int i : after) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] args) {
        if (args == null || args.length < 2)
            return args;
        for (int i = 1; i < args.length; i++) {
            for (int j = i - 1; j >= 0 && args[j] > args[j + 1]; j--) {
                swap(args, j, j + 1);
            }
        }

        return args;
    }

    private static void swap(int[] args, int j, int i) {
        args[j] = args[j] ^ args[i];
        args[i] = args[j] ^ args[i];
        args[j] = args[j] ^ args[i];
    }

    public int[] insertSort(int[] arr) {
        if (arr.lenth == 0 || arr.lenth == 1) return arr;

        int len = arr.lenth;
        for (int i = 1; i < len; i++) {
                int key = arr[i]; //  保存当前key值
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j--;
                }
                array[j + 1] = key;
        }
        return arr;
    }

    // 优化 使用二分查找法减少比较操作的数目
    public int[] binaryInsertSort(int arr[]) {
        if (arr.length == 0 || arr.length == 1) return arr;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int repIndex = binaryFind(arr, 0, i, i / 2); // 二分查找出待替换值
            replaceSwap(arr, repIndex, i);  // 从该节点开始往后推移
            return arr;
        }
    }
}
