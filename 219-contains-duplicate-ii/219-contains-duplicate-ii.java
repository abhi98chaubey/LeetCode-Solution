class Solution {
     public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(nums.length);
        
        for(int i = 0 ; i < nums.length; i++){
            if(hmap.containsKey(nums[i]) && (i-hmap.get(nums[i]) <= k)){
                return true;
            }
            hmap.put(nums[i], i);
        }
        
        return false;
    }
}