class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        // Frequency of text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        // Required frequency of "balloon"
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);

        int res = Integer.MAX_VALUE;

        for (Character ch : need.keySet()) {

            int fNeed = need.get(ch);
            int fHave = have.getOrDefault(ch, 0);

            int times = fHave / fNeed;

            res = Math.min(res, times);
        }

        return res;
    }
}