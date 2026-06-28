class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int minending = nums[0];
        int maxending = nums[0];
        int ans = nums[0];

        for(int i =1;i<n;i++){
            int V1= nums[i];
            int V2=minending * nums[i];
            int V3=maxending * nums[i];
            maxending = Math.max(V1,Math.max(V2,V3));
            minending = Math.min(V1,Math.min(V2,V3));
            ans = Math.max(ans, maxending);                 
        }
        return ans;
    }
}