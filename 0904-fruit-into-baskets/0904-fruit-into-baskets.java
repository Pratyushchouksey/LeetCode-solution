class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            int i = fruits[high];
            freq.put(i, freq.getOrDefault(i, 0) + 1);

            // shrink window if more than k unique
            while (freq.size() > 2) {
                int leftInt = fruits[low];
                freq.put(leftInt, freq.get(leftInt) - 1);
                if (freq.get(leftInt) == 0)
                    freq.remove(leftInt);
                low++;
            }

            // if exactly k unique, update answer
            if (freq.size() <= 2) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res;

    }
}