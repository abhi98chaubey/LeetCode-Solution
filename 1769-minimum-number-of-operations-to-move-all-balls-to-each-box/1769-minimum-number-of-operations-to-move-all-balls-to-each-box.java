class Solution {
    public int[] minOperations(String boxes) {
         List<Integer> havingOne=new ArrayList<>();       
        for(int i=0;i<boxes.length();i++)
        {
            char box=boxes.charAt(i);          
            if(box=='1')havingOne.add(i);         
        }       
        int Result[]=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++)
         for(int j:havingOne)
        Result[i]+=Math.abs(j-i);      
        return Result;
    }
}