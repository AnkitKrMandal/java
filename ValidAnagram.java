import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    /**
     * Returns true if s and t are anagrams (contain same characters with same frequencies).
     * Approach: count frequencies using a HashMap<Character, Integer>.
     * Time: O(n), Space: O(min(n, charset))
     *
     * Works for general Unicode characters. If you know input is only lowercase a-z,
     * using an int[26] is faster and simpler.
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!count.containsKey(c)) return false;
            count.put(c, count.get(c) - 1);
            if (count.get(c) == 0) count.remove(c);
        }
        // if map is empty, they are anagrams
        return count.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";

        System.out.println(s1 + " & " + t1 + " -> " + isAnagram(s1, t1)); // true
        System.out.println(s2 + " & " + t2 + " -> " + isAnagram(s2, t2)); // false
    }
}
