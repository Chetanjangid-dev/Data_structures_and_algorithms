from typing import List

class Solution:
    """
    LeetCode 15: 3Sum
    Problem Link: https://leetcode.com/problems/3sum/
    Complexity:
        Time: O(n^2) - Sorting takes O(n log n), and the nested loops take O(n^2).
        Space: O(1) or O(n) - Depending on the implementation of the sorting algorithm.
    """
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        sol = []
        
        for i in range(len(nums)):
            # Skip the same element to avoid duplicate triplets
            if i > 0 and nums[i] == nums[i-1]:
                continue
                
            first = i + 1
            last = len(nums) - 1
            
            while first < last:
                total = nums[i] + nums[first] + nums[last]
                
                if total == 0:
                    sol.append([nums[i], nums[first], nums[last]])
                    
                    # Skip duplicate values for 'first' pointer
                    while first < last and nums[first] == nums[first + 1]:
                        first += 1
                    # Skip duplicate values for 'last' pointer
                    while first < last and nums[last] == nums[last - 1]:
                        last -= 1
                        
                    first += 1
                    last -= 1
                    
                elif total < 0:
                    first += 1
                else:
                    last -= 1
                    
        return sol

if __name__ == "__main__":
    # Test Case
    sol = Solution()
    test_nums = [-1, 0, 1, 2, -1, -4]
    print(f"Input: {test_nums}")
    print(f"Output: {sol.threeSum(test_nums)}") 
    # Expected Output: [[-1, -1, 2], [-1, 0, 1]]
