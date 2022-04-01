class Solution {
    public int findCenter(int[][] edges) {
        int degree = edges.length;
        int u = edges[0][0];
        int v = edges[0][1];
        int counter1 = 0;
        int counter2 = 0;
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < 2; j++){
                if(u == edges[i][j]){
                    counter1++;
                }
                if(v == edges[i][j]){
                    counter2++;
                }
            }     
        }
        int star = 0;
        if(counter1 == degree){
            star = u;
        }
        if(counter2 == degree){
            star = v;
        }
        return star;
    }
}