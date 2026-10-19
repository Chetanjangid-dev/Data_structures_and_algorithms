class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set =  new HashSet<>();
        for(int i =0;i<nums.length;i++){set.add(nums[i]);}
        int maxlcs = 0;
        for(int  i = 0 ;i<nums.length;i++){
            if(!set.contains(nums[i])) continue;
            int lcs =1;
            int j = 1;
            while(set.contains(nums[i]-j)){
                set.remove(nums[i]-j);
                lcs++;
                j++;
            }
            j=1;
            while(set.contains(nums[i]+j)){
                set.remove(nums[i]+j);
                lcs++;
                j++;
            }
            maxlcs = Math.max(lcs,maxlcs);
        }
        return maxlcs;
    }
}