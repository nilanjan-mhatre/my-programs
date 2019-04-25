package com.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> set = new HashMap<>();
        List<Integer> result = new LinkedList<>();

        for(int i=0; i<nums1.length; i++) {
            set.put(nums1[i], true);
        }

        for(int i=0; i<nums2.length; i++) {
            if(set.containsKey(nums2[i]) && set.get(nums2[i])) {
                set.put(nums2[i], false);
                result.add(nums2[i]);
            }
        }
        int unique[] = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            unique[i] = result.get(i);
        }
        return unique;
    }
}