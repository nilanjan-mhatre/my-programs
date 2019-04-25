package com.string;

import java.util.HashMap;
import java.util.Map;

public class SubString {

    public static void main(String[] args) {

        //        String haystack = "abaabab"; //;
        //        String needle = "abab";

        //        String haystack = "aaa";
        //        String needle = "aaaa";

        String haystack = "mississippi";
        String needle = "sippi";

        System.out.println(new SubStringSolution().strStr(haystack, needle));
    }

}

class SubStringSolution {
    public int strStr(String haystack, String needle) {
        int index = 0;
        if(needle != null && needle.length() > 0) {
            Map<Character, Integer> shift = new HashMap<>();
            int len1 = haystack.length();
            int len2 = needle.length();
            int counter = 0;
            int i, j;
            Integer value;
            for(i=0; i<len2; i++) {
                if(!shift.containsKey(needle.charAt(i))) {
                    shift.put(needle.charAt(i), len2 - 1 - i);
                }
            }
            index = -1;
            while(counter < len1) {
                j = counter;
                for(i=0; i<len2 && j<len1; i++) {
                    if(haystack.charAt(j) != needle.charAt(i)) {
                        break;
                    }
                    j++;
                }
                if(i == len2) {
                    index = counter;
                    break;
                } else if(j<len1) {
                    value = shift.get(haystack.charAt(j));
                    if(value == null || value <= 0) {
                        value = 1;
                    }
                    counter += value;
                } else {
                    break;
                }
            }
        }
        return index;
    }
}