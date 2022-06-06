class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] hash = new int[60];
        for(int i=0; i<time.length; i++)
            hash[time[i]%60]++;
        
        int count = 0;
        count += countPairs(hash[0]);
        count += countPairs(hash[30]);
        
        for(int i=1; i<30; i++){
            
            count += hash[i]*hash[60-i];
        }
        return count;
    }
    
    public int countPairs(int num){
        if(num%2==0)
            return (num/2)*(num-1);
        return num*((num-1)/2);
    }
}