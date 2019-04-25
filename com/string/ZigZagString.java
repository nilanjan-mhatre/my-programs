package com.string;

public class ZigZagString {

    public static void main(String[] args) {

        //      System.out.println(new ZigZagStringSolution().convert("abcdefghijk", 4));
        System.out.println(new ZigZagStringSolution().convert("abcdefghijklmnopqrstu", 5));
        //      System.out.println(new ZigZagStringSolution().convert("a", 1));
        //        System.out.println(new ZigZagStringSolution().convert("ab", 2));
    }

}

class ZigZagStringSolution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder(s.length());
        if(numRows == 1) {
            result.append(s);
        } else {
            int index, step;
            int maxStep = (numRows - 1) * 2;
            int row = 0;

            while(row < numRows) {
                index = row;
                step = maxStep - row * 2;
                if(step == 0) {
                    step = maxStep;
                }

                while(index < s.length()) {
                    result.append(s.charAt(index));
                    index += step;
                    if(step != maxStep) {
                        step = maxStep - step;
                    }
                }

                row++;
            }
        }
        return new String(result);
    }
}