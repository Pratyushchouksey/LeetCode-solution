class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freqT = new int[256];
        int[] freqS = new int[256];

        // Fill freqT
        for (char c : t.toCharArray()) {
            freqT[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            freqS[r]++;

            // If this char contributes to requirement
            if (freqT[r] > 0 && freqS[r] <= freqT[r]) {
                formed++;
            }

            // When valid window
            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                freqS[l]--;

                // If removing breaks requirement
                if (freqT[l] > 0 && freqS[l] < freqT[l]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}