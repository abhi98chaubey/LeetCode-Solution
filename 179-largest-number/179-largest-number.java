class Solution {
    public String largestNumber(int[] nums) {
        String [] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++) strs[i] = String.valueOf(nums[i]);
        
        Quick(strs,0,nums.length-1);
        
        if(strs[0].equals("0")) return "0";
        
        StringBuilder str = new StringBuilder();
        for(String val: strs) str.append(val);
        
        return str.toString();
    }
    public void Quick(String[] nums, int start, int end){
        if(start>=end) return;
        int i = start;
        int j = end;
        
        String pivot = nums[end];
        
        while(i<=j){
            while(i<=j && Long.valueOf(nums[i]+pivot)>Long.valueOf(pivot+nums[i])) i++;
            while(i<=j && Long.valueOf(nums[j]+pivot)<Long.valueOf(pivot+nums[j])) j--;
            
            if(i<=j){
                String temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
        Quick(nums, start, j);
        Quick(nums, i, end);
    }
}