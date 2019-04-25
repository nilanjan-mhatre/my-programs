package com.array;

import java.util.Stack;

public class RainwaterTrap {

    public static void main(String[] args) {
        //        int height[] = {1,0,2,1,0,3,2,1,2,1};
        int height[] = {9,6,8,8,5,6,3};
        System.out.println(new RainwaterTrapSolution().trap(height));
    }
}

class RainwaterTrapSolution {
    public int trap(int[] height) {
        int volume = 0;
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int i, min;
        while(start < height.length - 1) {
            i = start + 1;
            while(i < height.length && height[i] < height[start]) {
                stack.push(height[i]);
                i++;
            }

            if(i == height.length) {
                i--;
                int prev = stack.pop();
                int temp = prev;
                while(prev >= temp && !stack.isEmpty()) {
                    temp = prev;
                    prev = stack.pop();
                    i--;
                }
                if(i < height.length - 1) {
                    stack.push(prev);
                    stack.push(temp);
                    i += 1;
                }
            }
            min = Math.min(height[start], height[i]);
            while(!stack.isEmpty()) {
                int diff = min - stack.pop();
                if(diff > 0) {
                    volume += diff;
                }
            }
            start = i;
        }

        return volume;
    }
}