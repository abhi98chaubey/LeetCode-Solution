class Solution {
    public int[] sortArrayByParity(int[] nums) {
        //2 pointer approach
        //Edge case
        if(nums.length==1){
            return nums;
        }
        
        int i=0;
        int j=0;
        
        while(i<nums.length){
            
            if((nums[i]&1)==0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            
            i++;
        }
        
        return nums;
    }
}