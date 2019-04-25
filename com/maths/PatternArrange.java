package com.maths;


/*
 * n=8
 *
 *  o
 *  oo
 *  ooo
 *  oo
 *
 *  result=3
 *
 */
public class PatternArrange {

    public static void main(String[] args) {

        System.out.println(new PatternArrangeSolution().arrangeCoins(6));
    }

}

class PatternArrangeSolution {
    /*public int arrangeCoins(int n) {
        int start = 0;
        int end = 65536;
        int mid, s;
        while(end - start > 1) {
            mid = (start + end) / 2;
            s = calculateSummation(mid);
            if(s > n) {
                end = mid;
            } else if (s < n) {
                start = mid;
            } else {
                start = mid;
                break;
            }
        }

        return start;
    }

    int calculateSummation(int number) {
        return (int) (number * (number / 2.0) + number / 2.0);
    }*/

    public int arrangeCoins(int n) {
        return (int) (-1/2.0 + Math.sqrt(4.0) * Math.sqrt(1/16.0 + n / 2.0));
    }
}