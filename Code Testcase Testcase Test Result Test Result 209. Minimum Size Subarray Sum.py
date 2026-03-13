class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
    
        first=0
        second=0
        min_length=0
        curr_sum=0
        while second<len(nums): 
         curr_sum=nums[second]+curr_sum
         while curr_sum>=target:
            length=1+second-first
            if min_length==0:
                min_length=length
            elif length<min_length:
                min_length=length
            if min_length==1:
                return 1
            curr_sum=curr_sum-nums[first]
            first+=1
         second+=1
        return min_length
