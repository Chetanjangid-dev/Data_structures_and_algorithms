class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int min_index = 0;
        int max_index = 0;
        int max = nums[max_index];
        int min =nums[min_index];
        for(int i = indexDifference ; i<nums.length;i++){
            //check wheteher max need to be upadetd bcz of new eleigible elein windq
            if(nums[i - indexDifference] > max){
                max_index = i - indexDifference;
                max = nums[max_index];
            }
            //same check for min
            if(nums[i-indexDifference] <min){
                min_index  = i - indexDifference;
                min = nums[min_index];
            }
            //check whether min value in ooru winrow forms the corrcet pair
            if(nums[i] - min>=valueDifference){
                    return new int[]{min_index,i};
            }
            //check whether max value in ooru winrow forms the corrcet pair
            if(max-nums[i]>=valueDifference){
                    return new int[]{max_index,i};
            }
        }
        return new int[]{-1,-1};
    }
}