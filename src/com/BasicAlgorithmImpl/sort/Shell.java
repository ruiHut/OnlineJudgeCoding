import com.sun.tools.javac.util.Context.Key;

/**
 * 希尔排序
 */


class solution {

    public static void shellSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return;

        int gap = arr.length >> 1; // 确认 gap
        while(gap >= 1) { // sort
            for (int i = gap; i < arr.length; i++) {    // 根据 gap 进行插入排序
                key = arr[i];
                j = i - gap;
                while (j >= 0 && arr[j] > key) {
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = key;
            }
            gap = gap / 2;
        }
    }
}