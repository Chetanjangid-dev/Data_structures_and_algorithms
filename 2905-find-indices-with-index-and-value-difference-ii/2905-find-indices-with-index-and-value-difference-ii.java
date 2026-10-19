class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;

        int ind1 = 0;
        int ind2 = 0;
        int x = nums[0], y = nums[0];

        // x, ind1 -> maximum element record
        // y, ind2 -> minimum element record
        for (int i = indexDifference; i < n; i++) {
            if (nums[i - indexDifference] > x) {
                x = nums[i - indexDifference];
                ind1 = i - indexDifference;
            }

            if (nums[i - indexDifference] < y) {
                y = nums[i - indexDifference];
                ind2 = i - indexDifference;
            }

            if (Math.abs(nums[i] - nums[ind1]) >= valueDifference) {
                return new int[]{ind1, i};
            }

            if (Math.abs(nums[i] - nums[ind2]) >= valueDifference) {
                return new int[]{ind2, i};
            }
        }

        return new int[]{-1, -1};
    }
}