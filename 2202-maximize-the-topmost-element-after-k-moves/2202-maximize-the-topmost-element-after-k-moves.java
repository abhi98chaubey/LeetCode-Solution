class Solution {
   public int maximumTop(int[] nums, int k) {
   if(k==0){return nums[0];}

    
    /* if K is 0, we dont have any steps, the top most would be the max possible */

    
     if(nums.length==1){
        
        if(k%2==0){
            return nums[0];
        }else{ return -1;}
        
    }
    
/* if array size is 1 only we will have to force remove it in the first turn and add it back in the second. so the value of K  being even or odd becomes important. if K is even we will have the first element back on top, else we will have this single element away.
   if K value is greater than the size of array, we know that maximum in the array would get                          stored as we have enough steps to pop out all elements and then place max on the top */
    
    
    
    
    int max=Integer.MIN_VALUE;
    
    int i=0;
    
    while(i<nums.length && k>1){
        
        max=Math.max(max,nums[i]);
        i++;
        k--;
    }
    
    
//we need to keep a track of maximum value till K number of elements, because no more than K elements can be removed from the list. 'LAST STEP' is decisive because you could remove the top most element to bring ne next element on top or you could simply pick up the max so far and put it back on the array. That is why i stopped the upper loop when K was 1.
    
    
    
   if(i+1 < nums.length){
           
          return Math.max(max,nums[i+1]);
       }else{
       
       return max;
   }
    
   }
}   