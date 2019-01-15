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
}
