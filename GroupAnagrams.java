import java.util.*;

public class GroupAnagrams {
    /**
     * Groups anagrams together.
     * Approach: for each word, compute a canonical key (sorted chars) and map key -> list.
     * Time: O(n * k log k) where k is average word length (sorting each word).
     * Space: O(n * k) for output.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;

        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        result.addAll(groups.values());
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> grouped = groupAnagrams(input);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Grouped anagrams:");
        for (List<String> group : grouped) {
            System.out.println(group);
        }
        // Example expected groups (order may vary):
        // [eat, tea, ate]
        // [tan, nat]
        // [bat]
    }
}
