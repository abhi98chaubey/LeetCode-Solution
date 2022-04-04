class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       int i=0;
        List<Integer> result=new ArrayList<>();
        while(i<nums.length){
            int j=nums[i]-1;
            if(nums[j]!=j+1){
                nums[i]=nums[j];
                nums[j]=j+1;
            }
            else i++;
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1) result.add(nums[j]);
        }
        return result;
    }
}