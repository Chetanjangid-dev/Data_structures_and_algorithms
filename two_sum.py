from typing import List

class Solution:
    """
    LeetCode 1: Two Sum
    Problem Link: https://leetcode.com/problems/two-sum/
    Complexity:
        Time: O(n log n) - due to sorting (current implementation)
        Space: O(n) - for storing indices in the hashmap
    """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        # Store original indices because sorting will change them
        hashmap = {}
        for i, num in enumerate(nums):
            if num in hashmap:
                hashmap[num].append(i)
            else:
                hashmap[num] = [i]

        # Sorting for the two-pointer approach
        sorted_nums = sorted(nums)
        first_ptr = 0
        last_ptr = n - 1

        while first_ptr < last_ptr:
            current_sum = sorted_nums[first_ptr] + sorted_nums[last_ptr]

            if current_sum == target:
                # Retrieve original indices
                first_idx = hashmap[sorted_nums[first_ptr]].pop(0)
                last_idx = hashmap[sorted_nums[last_ptr]].pop(0)
                return [first_idx, last_idx]
            
            elif current_sum < target:
                first_ptr += 1
            else:
                last_ptr -= 1

        return []

if __name__ == "__main__":
    # Test Case
    sol = Solution()
    print(f"Result: {sol.twoSum([2, 7, 11, 15], 9)}") # Expected: [0, 1]
