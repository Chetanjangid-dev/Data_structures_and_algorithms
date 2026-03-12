class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        temp_list = [0] * len(nums)
        first = 0
        last = len(nums) - 1

        for i in range(len(temp_list) - 1, -1, -1):
            if abs(nums[last]) >= abs(nums[first]):
                temp_list[i] = nums[last] * nums[last]
                last -= 1
            else:
                temp_list[i] = nums[first] * nums[first]
                first += 1

        return temp_list
