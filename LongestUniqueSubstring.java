import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    /**
     * Returns the length of the longest substring without repeating characters.
     *
     * Approach: sliding window with a map keeping last seen index of each char.
     * Time: O(n), Space: O(min(n, charset))
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0;
        int left = 0; // window start

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c)) {
                // move left to one past last occurrence (only forward)
                left = Math.max(left, lastIndex.get(c) + 1);
            }
            lastIndex.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * (Optional) Returns one longest substring without repeating characters.
     * If multiple, returns the first one found.
     */
    public static String longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return "";
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0, startOfMax = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c)) {
                left = Math.max(left, lastIndex.get(c) + 1);
            }
            lastIndex.put(c, right);
            int currLen = right - left + 1;
            if (currLen > maxLen) {
                maxLen = currLen;
                startOfMax = left;
            }
        }
        return s.substring(startOfMax, startOfMax + maxLen);
    }

    // Example usage
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Input: " + s1 + " -> length = " + lengthOfLongestSubstring(s1)
                + ", substring = \"" + longestUniqueSubstring(s1) + "\"");
        System.out.println("Input: " + s2 + " -> length = " + lengthOfLongestSubstring(s2)
                + ", substring = \"" + longestUniqueSubstring(s2) + "\"");
        System.out.println("Input: " + s3 + " -> length = " + lengthOfLongestSubstring(s3)
                + ", substring = \"" + longestUniqueSubstring(s3) + "\"");

        // Expected:
        // abcabcbb -> length 3, substring "abc"
        // bbbbb   -> length 1, substring "b"
        // pwwkew  -> length 3, substring "wke" (or "kew" depending on tie)
    }
}
