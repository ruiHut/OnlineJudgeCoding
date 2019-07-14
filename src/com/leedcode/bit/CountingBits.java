/**
 * 338 couting bits 
 * 1. eumns 0 ~ n 
 * 2. bits[i] = bits[i & (i -1)] + 1
 */


class solution {
    public int[] coutingBits(int n) {
        int[] res =  new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}