class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!count.containsKey(nums[i]))
                count.put(nums[i], 1);
            else
                count.remove(nums[i]);
        }
        int[] ans=new int[2];
        int place=0;
        for(int i : count.keySet()){
            ans[place]=i;
            place++;
            
                
        }
        return ans;
        
    }
}