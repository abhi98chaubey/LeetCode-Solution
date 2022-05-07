class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer>st=new Stack<>();
     int n=nums.length;
        int []min=new int[n];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            min[i]=Math.min(nums[i],min[i-1]);
            
        }
        for(int j=n-1;j>=0;j--){
            if(nums[j]>min[j]){
                while(st.size()>0 && st.peek()<=min[j]){
                    st.pop();
                }
                if(st.size()>0 && st.peek()<nums[j]){
                    return true;
                }
                st.push(nums[j]);
            }
        }
        return false;
    }
}