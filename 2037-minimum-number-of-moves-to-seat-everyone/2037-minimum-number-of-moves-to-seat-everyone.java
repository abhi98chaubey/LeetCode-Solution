class Solution {
    public int minMovesToSeat(int[] Se, int[] St) {
        Arrays.sort(Se);
        Arrays.sort(St);
        int ans=0;
        for(int i=0;i<Se.length;i++){
            ans+=Math.abs(Se[i]-St[i]);
        }
        return ans;
    }
}