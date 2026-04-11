class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {

        // brute force
        for(int i =0;i<arr.length-1;i++) {
        for(int j = i + 1; j < arr.length && j <= i + k; j++) { 
            if(arr[i] == arr[j]) 
            {
             return true;
             }}}
             return false;
        
        // optimal solution 
        // Set<Integer> set = new HashSet<>();

        // for (int i = 0; i < arr.length; i++) {

        //     if (set.contains(arr[i])) {
        //         return true;
        //     }

        //     set.add(arr[i]);

        //     if (set.size() > k) {
        //         set.remove(arr[i - k]);
        //     }
        // }

        // return false;
    }
}
