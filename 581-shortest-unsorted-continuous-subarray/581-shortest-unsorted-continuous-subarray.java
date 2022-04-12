class Solution {
    // Solution 1: Two Pointers, O(N), O(1)
    public int findUnsortedSubarray(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        
        // 1. find the pivot point from left where nums[i + 1] < nums[i]
        while (leftIndex < nums.length - 1 && nums[leftIndex] <= nums[leftIndex + 1]) {
            leftIndex++;
        }
        
        // if the leftIndex has already reached the last index then it means here is no pivot point.
        if (leftIndex == nums.length - 1) {
            return 0;
        }
        
        // 2. find the pivot point from right where nums[i - 1] > nums[i]
        while (rightIndex > 0 && nums[rightIndex - 1] <= nums[rightIndex]) {
            rightIndex--;
        }
            
        // 3. find the max and min value from the subarray
        int subMin = Integer.MAX_VALUE;
        int subMax = Integer.MIN_VALUE;
        for (int i = leftIndex; i <= rightIndex; i++) {
            subMin = Math.min(subMin, nums[i]);
            subMax = Math.max(subMax, nums[i]);
        }
        
        // 4. extend the subarray to the left if here is anything greater than the submin
        while (leftIndex > 0 && nums[leftIndex - 1] > subMin) {
            leftIndex--;
        }
        
        // 5. extend the subarray to the right if here is anything smaller than the subMax
        while (rightIndex < nums.length - 1 && nums[rightIndex + 1] < subMax) {
            rightIndex++;
        }
        
        return rightIndex - leftIndex +1;
    }
}