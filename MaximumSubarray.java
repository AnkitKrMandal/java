import java.util.Arrays;

public class MaximumSubarray {
    /**
     * Returns the maximum subarray sum using Kadane's algorithm.
     * Also returns start and end indices of one maximum subarray.
     *
     * Time: O(n), Space: O(1) extra.
     */
    public static Result maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return new Result(0, -1, -1);

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0, s = 0;

        for (int i = 1; i < nums.length; i++) {
            if (maxEndingHere + nums[i] < nums[i]) {
                maxEndingHere = nums[i];
                s = i;
            } else {
                maxEndingHere += nums[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }

        return new Result(maxSoFar, start, end);
    }

    // Small helper container
    public static class Result {
        public final int maxSum;
        public final int startIndex;
        public final int endIndex;

        public Result(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return "maxSum=" + maxSum + ", start=" + startIndex + ", end=" + endIndex;
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        Result r = maxSubArray(a);
        System.out.println("Input: " + Arrays.toString(a));
        System.out.println("Result: " + r);
        if (r.startIndex != -1) {
            System.out.println("Subarray: " + Arrays.toString(
                Arrays.copyOfRange(a, r.startIndex, r.endIndex + 1)));
        }
        // Expected: maxSum=6, subarray [4,-1,2,1]
    }
}
