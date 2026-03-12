class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return len(nums)
        k = 2  
        for j in range(2, len(nums)):
            if nums[j] != nums[k - 2]:
                nums[k] = nums[j]
                k += 1
        return k
