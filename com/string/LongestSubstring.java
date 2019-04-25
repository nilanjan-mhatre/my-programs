package com.string;

public class LongestSubstring {

    public static void main(String[] args) {

        System.out.println(new LongestSubstringSolution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringSolution().lengthOfLongestSubstring("a"));
        System.out.println(new LongestSubstringSolution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringSolution().lengthOfLongestSubstring("ababababababa"));
    }

}
class LongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLength = 0;

        if(len > 0) {
            int index = -1;
            String ch;
            int start = 0;
            int end = 1;
            StringBuilder sub = new StringBuilder();
            maxLength = 1;
            while(start < len - 1 && end < len) {
                sub.append(s.substring(start, end));
                while(end < len) {
                    ch = s.substring(end, end + 1);
                    index = sub.indexOf(ch);
                    if(index < 0) {
                        sub.append(ch);
                        end++;
                    } else {
                        break;
                    }
                }

                if(maxLength < end - start) {
                    maxLength = end - start;
                }
                if(index >= 0) {
                    start = start + index + 1;
                    sub.delete(0, sub.length());
                }
            }
        }
        return maxLength;
    }
}