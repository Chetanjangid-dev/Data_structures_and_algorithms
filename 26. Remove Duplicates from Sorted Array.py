class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        j = 1  
        k = 0   
        while j < len(nums):
            if nums[k] == nums[j]:
                j += 1
            else:
                nums[k + 1] = nums[j]
                k += 1
                j += 1
        
        return k + 1
