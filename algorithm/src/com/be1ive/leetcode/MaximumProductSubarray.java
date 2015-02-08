package com.be1ive.leetcode;

/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    //need to have two sums: max positive and min negative
    public int maxProduct(int[] A) {
        int pos = 0;
        int neg = 0;

        int max = Integer.MIN_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > 0) {
                pos = (pos == 0) ? A[i] : pos * A[i];
                neg = neg * A[i];
            } else if (A[i] < 0) {
                int tmp = pos;
                pos = neg * A[i];
                neg = (tmp == 0) ? A[i] : tmp * A[i];
            } else {
                pos = 0;
                neg = 0;

                if (max < 0) {
                    max = 0;
                }
            }

            if (pos > 0 && pos > max) {
                max = pos;
            } else if (neg < 0 && neg > max) {
                max = neg;
            }
        }

        return max;
    }
}
