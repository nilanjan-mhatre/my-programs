package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumbersSumZero {

    public static void main(String[] args) {

        //        int nums[] = {-1, 0, 1, 2, -1, -4};
        int nums[] = {-4, -4, -3, -1, 0, 0, 0, 1, 3, 3, 4, 4};
        //        int nums[] = {0};
        List<List<Integer>> result = new ThreeNumbersSumZeroSolution().threeSum(nums);

        for(List<Integer> sample : result) {
            for(Integer element : sample) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}

class ThreeNumbersSumZeroSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sample;
        int len = nums.length;
        int firstIndex = 0;
        int secondIndex, thirdIndex;

        while(firstIndex < len && nums[firstIndex] <= 0) {
            secondIndex = len - 1;
            while(secondIndex > firstIndex && nums[secondIndex] >= 0 && Math.abs(nums[firstIndex] + nums[secondIndex]) <= nums[secondIndex]) {
                thirdIndex = secondIndex - 1;
                while(thirdIndex > firstIndex) {
                    if(nums[firstIndex] + nums[secondIndex] + nums[thirdIndex] == 0) {
                        sample = new ArrayList<>();
                        sample.add(nums[firstIndex]);
                        sample.add(nums[secondIndex]);
                        sample.add(nums[thirdIndex]);
                        result.add(sample);
                        break;
                    }
                    thirdIndex--;
                }
                secondIndex--;
                while(secondIndex > firstIndex && nums[secondIndex] == nums[secondIndex + 1]) {
                    secondIndex--;
                }
            }
            firstIndex++;
            while(firstIndex < len && nums[firstIndex] == nums[firstIndex - 1]) {
                firstIndex++;
            }
        }

        return result;
    }

    public List<List<Integer>> getThreeSumList(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        if(end >= start + 2) {
            int sum, index;
            int indexChange = 0;
            sum = nums[start] + nums[end];
            List<Integer> sample;
            if(sum >= 0) {
                index = start + 1;
                indexChange = 1;
            } else {
                index = end - 1;
                indexChange = -1;
            }
            while(index < end && index > start) {
                if(nums[index] != nums[start] && nums[index] != nums[end] && sum + nums[index] == 0) {
                    break;
                }
                index += indexChange;
            }
            if(index < end && index > start) {
                sample = new ArrayList<>();
                sample.add(nums[start]);
                sample.add(nums[index]);
                sample.add(nums[end]);
                result.add(sample);
                getThreeSumList(nums, start++, end--);

            } else {
                if(sum >= 0) {
                    getThreeSumList(nums, start, end--);
                }
                if(sum <= 0) {
                    getThreeSumList(nums, start++, end);
                }
            }
        }
        return result;
    }
}