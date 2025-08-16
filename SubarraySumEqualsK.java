import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SubarraySumEqualsK {
    /**
     * Returns the number of continuous subarrays whose sum equals k.
     *
     * Approach: prefix-sum + hashmap storing counts of prefix sums seen so far.
     * For current prefix sum P, number of subarrays ending here with sum k is
     * countMap.get(P - k).
     *
     * Time: O(n), Space: O(n)
     */
    public static int subarraySumCount(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // zero prefix sum occurs once
        int prefix = 0, count = 0;

        for (int num : nums) {
            prefix += num;
            count += countMap.getOrDefault(prefix - k, 0);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Input: " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("Number of subarrays = " + subarraySumCount(nums, k));
        // Expected output: 2
    }
}
