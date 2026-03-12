class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        sol = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
             continue
            first = i + 1
            last = len(nums) - 1

            while first < last:
                total = nums[i] + nums[first] + nums[last]

                if total == 0:
                    sol.append([nums[i], nums[first], nums[last]])

                    while first < last and nums[first] == nums[first+1]:
                        first += 1
                    while first < last and nums[last] == nums[last-1]:
                        last -= 1

                    first += 1
                    last -= 1

                elif total < 0:
                    first += 1
                else:
                    last -= 1        
        return sol
