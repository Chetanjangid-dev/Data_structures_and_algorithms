class Solution(object):
    def subarraysDivByK(self, nums, k):
      count=0
      hashmap={}
      # we will inseert our fisrt sum as 0 jb tk aaray start nhi hua tb tk ta sum
      hashmap[0]=1
      sum=0
      for i in range(0,len(nums),1):
        sum+=nums[i]
        if hashmap.get(sum%k,False):
            freq=hashmap.get(sum%k)
            count+=freq
        hashmap[sum%k]=hashmap.get(sum%k,0)+1
      return count

