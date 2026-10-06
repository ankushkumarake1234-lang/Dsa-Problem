import java.lang.*;
import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        // First window
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        // Store maximum of first window
        ans[0] = nums[dq.peekFirst()];
        // Remaining windows
        for (int i = k; i < n; i++) {
            // Remove expired index
            if (!dq.isEmpty() &&
                dq.peekFirst() == i - k) {
                dq.removeFirst();
            }
            // Remove smaller elements
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            // Add current index
            dq.addLast(i);
            // Maximum of current window
            ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}