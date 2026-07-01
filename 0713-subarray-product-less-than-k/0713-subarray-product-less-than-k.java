class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // bcz pos integers ka array h or k 0 ho to 09 se lesser product nhi aa skta aaray me 
        if(k==0){
            return 0;
        }
        int first=0;
        int second=0;
        long product=1;
        int count=0;
        while(second<nums.length){
            product = product*nums[second];
            while(product>=k && first<=second){
              product=product/nums[first];
              first+=1;
            }
            count+=second-first+1;
            second+=1;
        }
        return count;
    }
}