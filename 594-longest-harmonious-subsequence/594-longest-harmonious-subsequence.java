class Solution {
   public int findLHS(int[] nums) {
	Arrays.sort(nums);
	var length = 0;
	for (int left = 0, right = 1; right < nums.length; ) {
		var diff = nums[right] - nums[left];
		if (diff == 1)
			length = Math.max(length, ++right - left);
		else if (diff < 1)
			right++;
		else
			left++;
	}
	return length;
}
}