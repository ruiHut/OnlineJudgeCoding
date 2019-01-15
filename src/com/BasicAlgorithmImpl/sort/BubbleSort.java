package BasicAlgorithmImpl.sort;

import java.util.Arrays;

/**
 * @program: LeedCode3
 * @description: 冒泡排序
 * @author: Mr.Zhou
 * @create: 2019-01-15 14:29
 **/

public class BubbleSort {
    public static void main(String[] args) {
        int[] before = generateRandomArray(100 ,50);
        // 生成一个随机器
        // Arrays.sort(before); 一个绝对正确的方法
        // 大样本测试
        int[] after = BubbleSort.sort(before);
        for (int i :
                after) {
            System.out.println(i);
        }
    }

    /**
     * for test
     * 生成长度随机的数组
     * @param
     * @return
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    private static int[] sort(int[] args) {
        if (args == null || args.length < 2)
            return args;
        for (int i = args.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (args[j] > args[j + 1])
                    swap(args, j, j + 1);
            }
        }
        return args;
    }

    private static void swap(int[] args, int j, int i) {
        args[j] = args[j] ^ args[i];
        args[i] = args[i] ^ args[j];
        args[j] = args[j] ^ args[i];
    }
}
