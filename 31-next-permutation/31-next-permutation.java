class Solution {
    public void nextPermutation(int[] nums) {
        
        // Find the index of first decreasing element
        int decreasingIndex = -1;
        for(int i=nums.length - 1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                decreasingIndex = i-1;
                break;
            }
        }
        
        // If no decreasing elemnt found, it mean array is in descending order. Just reverse the array
        if(decreasingIndex == -1) {
            reverseArray(nums, 0, nums.length-1);
            return;
        }
        
        // Find the element to the right of decreasing element that is just higher than decreasing element and swap
        for(int i=nums.length-1; i>=decreasingIndex+1; i--) {
            if(nums[i] > nums[decreasingIndex]) {
                // Swap
                swap(nums, i, decreasingIndex);
                
                // Reverse the array from right of decreasing element so that it is in ascending order
                reverseArray(nums, decreasingIndex+1, nums.length-1);
                break;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void reverseArray(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}