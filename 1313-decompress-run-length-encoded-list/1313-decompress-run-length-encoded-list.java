class Solution {
    public int[] decompressRLElist(int[] nums) {
        int sum=0;
        int k=0;
        int freq = nums[0];
        for(int i=0;i<nums.length/2;i++)
            sum+=nums[2*i];
        
        int[] a = new int[sum];
        for(int i=0;i<nums.length/2;i++)
        {
            freq=nums[2*i];
            while(freq!=0)
            {
                a[k]=nums[2*i+1];
                k++;
                freq--;
            }
        }
        return a;
    }
}