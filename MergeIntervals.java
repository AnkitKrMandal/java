import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class MergeIntervals {
    /**
     * Merges overlapping intervals.
     *
     * Input format: int[][] intervals where intervals[i] = {start, end}.
     * Approach: sort by start, then scan and merge.
     *
     * Time: O(n log n) for sorting, Space: O(n) for output (or O(1) extra ignoring output).
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                // overlap -> merge by extending end
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    // Example usage
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Input: " + Arrays.deepToString(intervals));
        int[][] out = merge(intervals);
        System.out.println("Merged: " + Arrays.deepToString(out));
        // Expected: [[1,6],[8,10],[15,18]]
    }
}
