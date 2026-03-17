class Solution(object):
    def subarraysWithKDistinct(self, nums, k):
        def valid(k):
            if k<=0:
                return 0
            left=0
            right=0
            hashmap={}
            count=0
            while right<len(nums):
                hashmap[nums[right]]=hashmap.get(nums[right],0)+1
                while len(hashmap)>k:
                    hashmap[nums[left]]-=1
                    if hashmap[nums[left]]==0:
                        del hashmap[nums[left]]
                    left+=1
                count=count+right-left+1    
                right+=1
            return count
        return valid(k)-valid(k-1)
