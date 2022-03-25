class Solution {
    public boolean canJump(int[] nums) {
        int last=nums.length-1;
        
        for(int i=last;i>=0;i--){
            if(nums[i]+i>=last){
                last=i;
            }
            
           
        }
        return last==0;
    }
}