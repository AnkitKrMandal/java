public class LongestPalindromicSubstring {
    /**
     * Returns the longest palindromic substring using expand-around-center.
     *
     * Time: O(n^2) worst-case, Space: O(1) extra (excluding output)
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0; // inclusive indices of best palindrome

        for (int i = 0; i < s.length(); i++) {
            // odd length (center at i)
            int len1 = expandFromCenter(s, i, i);
            // even length (center between i and i+1)
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                // compute new start and end from center i and length
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // Expand around left/right and return length of palindrome
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // when loop exits, left and right are one step beyond the palindrome
        return right - left - 1;
    }

    // Example usage
    public static void main(String[] args) {
        String a = "babad";
        String b = "cbbd";
        String c = "a";
        String d = "forgeeksskeegfor";

        System.out.println("Input: " + a + " -> longest palindrome: \"" + longestPalindrome(a) + "\"");
        System.out.println("Input: " + b + " -> longest palindrome: \"" + longestPalindrome(b) + "\"");
        System.out.println("Input: " + c + " -> longest palindrome: \"" + longestPalindrome(c) + "\"");
        System.out.println("Input: " + d + " -> longest palindrome: \"" + longestPalindrome(d) + "\"");

        // Expected outputs (note ties may return either valid palindrome):
        // "bab" or "aba"
        // "bb"
        // "a"
        // "geeksskeeg"
    }
}
