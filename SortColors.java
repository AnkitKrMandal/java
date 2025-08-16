import java.util.Arrays;

public class SortColors {
    /**
     * Sorts array containing only 0,1,2 in-place (Dutch National Flag).
     *
     * Approach: three pointers low, mid, high.
     * - nums[0..low-1] = 0
     * - nums[low..mid-1] = 1
     * - nums[mid..high] = unknown
     * - nums[high+1..end] = 2
     *
     * Time: O(n), Space: O(1)
     */
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
                // don't increment mid here because swapped value must be examined
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        System.out.println("Before: " + Arrays.toString(arr));
        sortColors(arr);
        System.out.println("After:  " + Arrays.toString(arr));
        // Expected: [0,0,1,1,2,2]
    }
}
