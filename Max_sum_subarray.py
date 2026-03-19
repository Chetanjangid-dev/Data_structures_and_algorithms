class Solution(object):
    def maxSubArray(self, nums):
        prev = nums[0]
        best_answer = nums[0]

        for i in range(1, len(nums)):
            prev = max(nums[i], prev + nums[i])
            best_answer = max(best_answer, prev)

        return best_answer
