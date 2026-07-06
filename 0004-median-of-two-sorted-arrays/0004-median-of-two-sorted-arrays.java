class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int requiredLeft = (m + n + 1) / 2;
        
        int low = 0;
        int high = m; // Use m instead of m-1 for proper binary search
        
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = requiredLeft - cut1;
            
            // Handle edge cases for nums1
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            
            // Handle edge cases for nums2 - FIXED: use cut2 for nums2
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
            
            // Check if we found the correct partition
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    // Even length: average of two middle elements
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    // Odd length: left middle element
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                // Move cut1 to the left
                high = cut1 - 1;
            } else {
                // Move cut1 to the right
                low = cut1 + 1;
            }
        }
        
        // Should never reach here if inputs are valid
        return 0.0;
    }
}