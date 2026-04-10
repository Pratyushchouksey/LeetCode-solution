class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            
            //  Case 1: Odd length
            int left = i;
            int right = i;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left;
                }

                left--;
                right++;
            }

            //  Case 2: Even length
            left = i;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}