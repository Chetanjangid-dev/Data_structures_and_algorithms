class Solution:
    def smallestSumSubarray(self, A, N):
        prev = A[0]
        min_sum = A[0]

        for i in range(1, N):
            prev = min(A[i], prev + A[i])
            min_sum = min(min_sum, prev)

        return min_sum
