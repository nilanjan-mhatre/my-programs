package com.array;

public class MaxSumOf2SubArrays {

    public static void main(String[] args) {

        //        int[] A = {2,1,5,6,0,9,5,0,3,8};
        //        int L = 4;
        //        int M = 3;
        int[] A = {1,6,5,2,2,5,1,9,4};
        int L = 1;
        int M = 2;
        System.out.println(new MaxSumOf2SubArraysSolution().maxSumTwoNoOverlapDP(A, L, M));
    }

}

class MaxSumOf2SubArraysSolution {
    public int maxSumTwoNoOverlapDP(int[] A, int L, int M) {
        for (int i = 1; i < A.length; ++i) {
            A[i] += A[i - 1];
        }
        for (int i=0; i<A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
        for (int i = L + M; i < A.length; ++i) {
            System.out.println(Lmax + " " + Mmax);
            Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
            Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
        }
        return res;
    }

}