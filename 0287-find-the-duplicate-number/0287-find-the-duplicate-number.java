class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        while(true ){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast){
                if(slow==nums[0]){
                    return slow;
                }
                slow=nums[0];
                while(slow!=fast){
                    slow=nums[slow];
                    fast=nums[fast];
                    if(slow==fast){
                        return slow;
                    }
                }
            }
        }
    }
}