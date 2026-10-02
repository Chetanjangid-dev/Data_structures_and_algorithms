class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> processed = new HashSet<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - k)) {
                 processed.add( Arrays.asList(nums[i]-k,nums[i]) );
            }
            if (set.contains(nums[i] + k) ) {
                processed.add( Arrays.asList(nums[i],nums[i]+k) );
            }

            set.add(nums[i]);
        }

        return processed.size();
    }
}