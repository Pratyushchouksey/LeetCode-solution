class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int zero = 0;
        int one = 0;
        int res = 0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero ++;
            }else{
                one ++;
            }

            int diff = zero-one;

            if (map.containsKey(diff)) {  //Ye difference pehle bhi aa chuka hai.
                res = Math.max(res, i - map.get(diff)); //Maximum length update kar dete hain.
            } else {
                map.put(diff, i);  //Ye difference pehli baar mila.
            }
        }
        return res;
    }
}