class Solution:
    def numSubarraysWithSum(self, nums, goal):
      def cal(goal):
        if goal<0:
            return 0
        left=0
        right=0
        count=0
        sum=0
        while right<len(nums):
            sum=nums[right]+sum
            while sum>goal:
                sum=sum-nums[left]
                left+=1
            count=count+right-left+1
            right+=1
        return count
      return  cal(goal)-cal(goal-1)
        
