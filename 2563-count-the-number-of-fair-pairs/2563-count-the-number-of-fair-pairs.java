class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count =0;
        for(int i  = 0 ; i<nums.length-1;i++){
            int low = i+1;
            int high  = nums.length-1;
            int target = upper - nums[i];
            int ans1 = -1;
            while(low<=high){
                int mid =(low+high)/2;
                if(nums[mid]<=target){
                    ans1 = mid;
                    low = mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            int ans2 = -1;
            low = i+1;
            high = ans1;
            target = lower-nums[i];
            while(low<=high){
                int mid =(low+high)/2;
                if(nums[mid]>=target){
                    ans2 = mid;
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            if(ans2 != -1)
                count += ans1 - ans2 + 1;
        }
        return count;
    }
}