
class Solution {
    int[] nums;

    int binarysearch(int query) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= query) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ans = new ArrayList<>();

        this.nums = nums;
        Arrays.sort(nums);

        int n = nums.length;
        long[] prefix = new long[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int query : queries) {
            int index = binarysearch(query);

            long leftSum = index >= 0 ? prefix[index] : 0L;
            long leftCount = index + 1;

            long rightSum = prefix[n - 1] - leftSum;
            long rightCount = n - leftCount;

            long res = (long) query * leftCount - leftSum;
            res += rightSum - (long) query * rightCount;

            ans.add(res);
        }

        return ans;
    }
}
