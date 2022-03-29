class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // SumA: stores the sum of all candies Alice is having
        int SumA = 0;
        
        // SumB: stores the sum of all candies Bob is having
        int SumB = 0;
        
        // set: stores the Unique no. of candies Bob is having
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<aliceSizes.length; i++){
            SumA += aliceSizes[i];
        }
        
        for(int i=0; i<bobSizes.length; i++){
            SumB += bobSizes[i];
            set.add(bobSizes[i]);
        }
        
        /*
            Let,
            x: No. of candies alice is giving
            y: No. of candies alice is receiving
            
            Acc. to ques:
                SumA - x + y = SumB + x - y
                2y = (SumB - SumA + 2x) / 2
                y = (SumB - SumA) / 2 + 2 / 2
                y = (SumB - SumA) / 2 + x
        */
        
        int delta = (SumB - SumA)/2;
        
        for(int i=0; i<aliceSizes.length; i++){
            if( set.contains( aliceSizes[i] + delta )){
                return new int[]{ aliceSizes[i], aliceSizes[i] + delta };
            }
        }
        throw null;
    }
}