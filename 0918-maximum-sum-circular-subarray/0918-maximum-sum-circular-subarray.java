class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        // For Maximum Subarray
        int maxEnding = nums[0];
        int maxSum = nums[0];

        // For Minimum Subarray
        int minEnding = nums[0];
        int minSum = nums[0];

        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
            if(i>0){
            // Kadane for Maximum Sum
                maxEnding = Math.max(nums[i], maxEnding + nums[i]);
                maxSum = Math.max(maxSum, maxEnding);

                // Kadane for Minimum Sum
                minEnding = Math.min(nums[i], minEnding + nums[i]);
                minSum = Math.min(minSum, minEnding);
            }
        }
        // Edge Case: All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Return the maximum of normal and circular subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}