class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int bestending = nums[0];
        int ans = nums[0];

        for(int i=1;i<n;i++){
            int V1 = bestending + nums[i];
            int V2 = nums[i];
            bestending = Math.max(V1,V2);
            ans = Math.max(ans,bestending);
        }
        return ans;
    }
}