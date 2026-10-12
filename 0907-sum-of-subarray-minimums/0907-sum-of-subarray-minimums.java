
import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Calculate sum of subarray minimums
        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            long contribution = (left * right % MOD) * arr[i] % MOD;
            total = (total + contribution) % MOD;
        }

        return (int) total;
    }
}
