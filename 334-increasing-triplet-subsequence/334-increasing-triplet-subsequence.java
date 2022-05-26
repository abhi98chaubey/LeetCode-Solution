class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int small=Integer.MAX_VALUE;
        int big=Integer.MAX_VALUE;
        
        for(int t:nums)
        {
            if(t<small)
                small=t;
            else if (small<t && t <big)
                big=t;
            else if(big < t)
                return true;
        }
        return false;
	}
}