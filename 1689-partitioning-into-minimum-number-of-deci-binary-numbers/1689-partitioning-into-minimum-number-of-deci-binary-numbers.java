class Solution {
    public int minPartitions(String n) {
         int max=0;
 for(char val:n.toCharArray()){
     if(val-'0'>max){
         max=val-'0';
     }
 }
    return max;
    }
}