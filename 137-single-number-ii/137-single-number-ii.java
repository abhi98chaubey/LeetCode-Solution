class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int element : nums){
            // if element is repeated only once ones will contain that element
            ones = (ones ^ element) & ~(twos);
            twos = (twos ^ element) & ~(ones);
        }
        return ones;
    }
}