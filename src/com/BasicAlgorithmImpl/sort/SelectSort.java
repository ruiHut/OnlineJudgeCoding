package BasicAlgorithmImpl.sort;

/**
 * @program: LeedCode3
 * @description: 选择排序
 * @author: Mr.Zhou
 * @create: 2019-01-15 15:09
 **/

public class SelectSort {
    public static void main(String[] args) {
        int[] before = new int[]{1, 5, 2, 3, 6, 7, 2};
        int[] after = SelectSort.sort(before);
        for (int i : after) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] args) {
        if (args == null || args.length < 2)
            return args;
        for (int i = 0; i < args.length - 1; i++) {
            int max  = i;
            for (int j = i + 1; j < args.length ; j++) {
                max = args[j] < args[max] ?  j : max;
            }
            swap(args, i, max);
        }
        
        return args;
    }

    private static void swap(int[] args, int j, int i) {
        args[j] = args[j] ^ args[i];
        args[i] = args[i] ^ args[j];
        args[j] = args[j] ^ args[i];
    }
}
