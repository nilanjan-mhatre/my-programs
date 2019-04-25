package com.array;

public class MaxSubArraySum {

	public static void main(String[] args) {

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		int result = new MaxSubArraySumSolution().maxSubArray(nums);
		System.out.println(result);
	}

}

class MaxSubArraySumSolution {
    public int maxSubArray(int[] nums) {
    	int maxSum = Integer.MIN_VALUE;
    	int sum = 0;

    	for(int i=0; i<nums.length; i++) {
    		if(i>0 && (nums[i] + sum < nums[i])) {
    			sum = 0;
    		}
    		sum += nums[i];
    		if(sum > maxSum) {
    			maxSum = sum;
    		}
    	}

		return maxSum;
    }
}