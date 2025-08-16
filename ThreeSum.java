import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    /**
     * Returns a list of unique triplets [a, b, c] such that a + b + c == 0.
     * Each triplet in non-decreasing order, and the result contains no duplicates.
     *
     * Approach: sort + for-loop + two-pointer.
     * Time: O(n^2), Space: O(1) extra (output space excluded)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    int leftVal = nums[left];
                    int rightVal = nums[right];
                    while (left < right && nums[left] == leftVal) left++;
                    while (left < right && nums[right] == rightVal) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("3Sum triplets:");
        for (List<Integer> t : triplets) {
            System.out.println(t);
        }
        // Expected output:
        // [-1, -1, 2]
        // [-1, 0, 1]
    }
}
