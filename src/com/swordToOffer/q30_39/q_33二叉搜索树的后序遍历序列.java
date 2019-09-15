package com.swordToOffer.q30_39;

public class q_33二叉搜索树的后序遍历序列 {

    public boolean VerifySquenecOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return Verify(sequence, 0, sequence.length - 1);
    }

    private boolean Verify(int[] sequence, int left, int right) {
        if (left > right)
            return true;

        int rootVal = sequence[right];
        int curIndex = left;
        while (curIndex < right && sequence[curIndex] <= rootVal)
            curIndex++;

        for (int i = curIndex; i < right; i++)
            if (sequence[i] < rootVal)
                return false;

        return Verify(sequence, left, curIndex - 1) && Verify(sequence, curIndex, right - 1);
    }
}
