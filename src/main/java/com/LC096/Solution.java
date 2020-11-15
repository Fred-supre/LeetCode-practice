package com.LC096;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        int n = 10;

        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < n+1; i++) {
            int sum = 0;
            for (int j=0; j < i; j++) {
                sum += result[j] * result[i - j - 1];
            }
            result[i] = sum;
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
