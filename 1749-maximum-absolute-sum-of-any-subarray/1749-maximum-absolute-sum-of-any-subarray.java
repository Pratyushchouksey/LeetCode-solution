class Solution {
    public int maxAbsoluteSum(int[] nums) {

            int maxEnding = 0, maxSum = 0;

            for (int num : nums) {
                maxEnding = Math.max(num, maxEnding + num);
                maxSum = Math.max(maxSum, maxEnding);
            }

            int minEnding = 0, minSum = 0;

            for (int num : nums) {
                minEnding = Math.min(num, minEnding + num);
                minSum = Math.min(minSum, minEnding);
            }
            
            return Math.max(maxSum, Math.abs(minSum));
    }
}