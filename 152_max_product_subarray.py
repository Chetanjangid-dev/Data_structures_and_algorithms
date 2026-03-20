from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        max_prod = nums[0]
        min_prod = nums[0]
        result = nums[0]

        for i in range(1, len(nums)):
            num = nums[i]

            # If number is negative, swap max and min
            if num < 0:
                max_prod, min_prod = min_prod, max_prod

            # Either take current number or extend previous subarray
            max_prod = max(num, max_prod * num)
            min_prod = min(num, min_prod * num)

            result = max(result, max_prod)

        return result
