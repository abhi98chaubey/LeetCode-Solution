class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] top = new int[6];
        int[] bottom = new int[6];
        int len = tops.length;
        int ans = Integer.MAX_VALUE;
        for(int i =  0; i<len;i++){
            top[tops[i]-1]++;
            bottom[bottoms[i]-1]++;
        }
        for(int j = 0; j<6 ;j++){
            if(top[j]==len || bottom[j]==len) return 0;
            if(top[j]+bottom[j]>=len) break;
            if(j==5) return -1;
        }
        for(int k = 0; k<6 ;k++){
            int temp = 0;
            boolean check = true;
            if(top[k]>=len/2){
            for(int x = 0; x<len ;x++){
                if(k+1 !=tops[x] && k+1 == bottoms[x]) temp++;
                else if(k+1 != tops[x] && k+1 != bottoms[x]){
                    check = false;
                    break;
                }
            }
            if(check) ans = Math.min(ans,temp);
            }
        }
       for(int y = 0; y<6 ;y++){
           int temp = 0;
           boolean check = true;
           if(bottom[y]>=len/2){
            for(int z= 0; z<len ;z++){
                if(y+1 !=bottoms[z] && y+1 == tops[z]) temp++;
                else if(y+1 != bottoms[z] && y+1 !=tops[z]){
                    check = false;
                    break;
                }
            }
            if(check) ans = Math.min(ans,temp);
            }
       }
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }
}