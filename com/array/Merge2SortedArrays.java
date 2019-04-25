package com.array;

public class Merge2SortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};

        new Merge2SortedArraysSolution().merge(nums1, 3, nums2, nums2.length);

        for (int n : nums1) {
            System.out.println(n + " ");
        }
    }

}

class Merge2SortedArraysSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index21 = 0;
        int index22 = 0;
        int temp;

        while(index1 < m) {
            if(index22 < n) {
                if(nums2[index21] > nums2[index22] && nums1[index1] > nums2[index22]) {
                    swap(nums1, nums2, index1, index22);
                    index22++;
                } else if(nums2[index22] > nums2[index21] && nums1[index1] > nums2[index21]) {
                    swap(nums1, nums2, index1, index21);
                }
            } else {
                break;
            }
            index1++;
        }
        while(index21 < index22) {
            nums1[index1++] = nums2[index22++];
        }
    }

    private void swap(int[] nums1, int[] nums2, int index1, int index2) {
        int temp;
        temp = nums1[index1];
        nums1[index1] = nums2[index2];
        nums2[index2] = temp;
    }
}