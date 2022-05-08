class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int maxOr = Integer.MIN_VALUE;
    
    public int countMaxOrSubsets(int[] nums) {
        generateSubSet(nums, new ArrayList<Integer>(), 0);
        return maxOr;
    }
    
    public void generateSubSet(int[] nums, List<Integer> cur, int index){
        if(index <= nums.length){
            int localXOR = 0;
            for(int i = 0; i<cur.size(); i++){
                localXOR |= cur.get(i);
            }
            map.put(localXOR, map.getOrDefault(localXOR,0)+1);
            maxOr = Math.max(map.get(localXOR), maxOr);    
        }
        for(int i = index; i<nums.length; i++){
            cur.add(nums[i]);
            generateSubSet(nums, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
}