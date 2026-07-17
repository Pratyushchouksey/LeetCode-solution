class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){ //true
               map.put(nums[i],map.get(nums[i]) +1);
            }else{
               map.put(nums[i],1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)>n/3){
            ans.add(key);
            }
        }
        return ans;
    }
}