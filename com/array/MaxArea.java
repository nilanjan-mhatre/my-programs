package com.array;

public class MaxArea {

    public static void main(String[] args) {
        int[] container = {1,8,6,2,5,4,8,3,7};
        System.out.println(new MaxAreaSolution().maxArea(container));
    }

}

class MaxAreaSolution {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int area;

        while(left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            if(area > max) {
                max = area;
            }
            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}