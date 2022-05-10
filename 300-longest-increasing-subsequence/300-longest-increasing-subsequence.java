class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        int[] max = new int[len];
        Arrays.fill(max, 1);
        int maxRes = 1;

      
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    max[i] = Math.max(max[i], 1 + max[j]);
                    maxRes = Math.max(maxRes, max[i]);
                }
            }
        }
        return maxRes;
    }
}