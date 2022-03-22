class Solution {
    public boolean divideArray(int[] nums) {
        final boolean[]unpaired = new boolean[501];// (per given constraint, support input range of 1..500)
        int unpairCt=0;
        for (int n:nums)
            unpairCt += ((unpaired[n]=!unpaired[n])?1:-1);
        return unpairCt==0;
    }
}