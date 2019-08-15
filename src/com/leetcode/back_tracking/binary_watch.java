package com.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * q_401 solution
 * 1. generate use double for
 * 2. backTracking
 */

// generate solution
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++) // all the times possible
                if (Integer.bitCount((h << 6) + m) == num)  // split hour，min
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}

// backTracking
class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] watch = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();
        backTrcaking(num, res, watch, 0, 0, 0);
        return res;
    }

    private void backTrcaking(int num, List<String> res, int[] watch, int wtStart, int h, int m) {
        if (h > 11 || m > 59) {
            return;
        } else if (num == 0) {
            String time = "";
            if(m < 10) {
                time += h + ":0" + m;
            }
            else {
                time += h + ":" + m;
            }
            res.add(time);
        } else {
            for(int i = wtStart; i < watch.length; i++) {
                if(i <= 3) {
                    backTrcaking(num - 1, res, watch,i + 1, h + watch[i], m);
                }
                else {
                    backTrcaking(num - 1, res, watch, i + 1, h, m + watch[i]);
                }
            }
        }
    }
}