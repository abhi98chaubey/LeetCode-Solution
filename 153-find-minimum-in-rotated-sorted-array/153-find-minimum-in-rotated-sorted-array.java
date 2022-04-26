class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0 , nums.length - 1);
    }
    
    public int find(int[] nums, int l, int r) {
        if(l == r) return nums[l];
        else if((r - l) == 1) return nums[l] > nums[r] ? nums[r] : nums[l];
        
        int mid = l + (r - l) / 2;
        int val = nums[mid];
        
        if(nums[l] > nums[r]) { // 8 9 10 11 12 13 14 15 16 17 1... 7
            if(val < nums[l])  // search left side
                return find(nums, l, mid);
            else  // search right side
                return find(nums, mid + 1, r);
        }
        else if(nums[l] < val) // 1 2 3 4 5 6 7 8
            return find(nums, l, mid); // search left side
        else 
             return find(nums, mid + 1, r); // search right side
    }
}