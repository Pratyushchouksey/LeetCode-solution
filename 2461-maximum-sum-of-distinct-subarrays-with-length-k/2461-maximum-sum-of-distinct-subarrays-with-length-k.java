class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int low = 0;
        long sum = 0;
        long res = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {

            sum += nums[high];
            freq.put(nums[high], freq.getOrDefault(nums[high], 0) + 1);

            if (high - low + 1 > k) {
                sum -= nums[low];
                freq.put(nums[low], freq.get(nums[low]) - 1);
                if (freq.get(nums[low]) == 0) {
                    freq.remove(nums[low]);
                }
                low++;
            }

            if (high - low + 1 == k && freq.size() == k) {
                res = Math.max(res, sum);
            }
        }

        return res;
    }
}