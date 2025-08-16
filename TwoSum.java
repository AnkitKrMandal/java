import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {
    /**
     * Returns indices of the two numbers such that they add up to target.
     * If no solution found, returns {-1, -1}.
     * Assumes exactly one solution in common LeetCode variant; this implementation
     * returns the first matching pair found.
     *
     * Time: O(n), Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) return new int[]{-1, -1};
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }
            // store current value -> index
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output indices: " + Arrays.toString(result));
        // Expected output: [0, 1]
    }
}
