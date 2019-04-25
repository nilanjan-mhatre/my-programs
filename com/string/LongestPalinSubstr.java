package com.string;

public class LongestPalinSubstr {

    public static void main(String[] args) {

        System.out.println(new LongestPalinSubstrSolution().longestPalindrome("abc"));
    }

}

class LongestPalinSubstrSolution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i=0; i<s.length(); i++) {
            String s1 = checkPalindrome(s, i - 1, i + 1);
            String s2 = checkPalindrome(s, i, i + 1);
            if(s1.length() > s2.length() && s1.length() > longest.length()) {
                longest = s1;
            }
            if(s2.length() > s1.length() && s2.length() > longest.length()) {
                longest = s2;
            }
        }
        return longest;
    }

    public String checkPalindrome(String s, int start, int end) {
        System.out.println(start + " " + end);
        if(start >= 0 && end < s.length() &&s.charAt(start) == s.charAt(end)) {
            return checkPalindrome(s, start - 1, end + 1);
        }
        return s.substring(start + 1, end);
    }
}