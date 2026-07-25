class Solution {
    public boolean isPalindrome(int x) {
        // Negative number kabhi palindrome nahi hota
        if (x < 0) {
            return false;
        }

        int divisor = 1;

        // Left pointer ke liye divisor banana
        while (x / divisor >= 10) {
            divisor *= 10;
        }

        while (x != 0) {

            // Left digit
            int left = x / divisor;

            // Right digit
            int right = x % 10;

            if (left != right) {
                return false;
            }

            // Left digit remove
            x = x % divisor;

            // Right digit remove
            x = x / 10;

            // Dono pointers andar aaye
            divisor = divisor / 100;
        }

        return true;
    }
}