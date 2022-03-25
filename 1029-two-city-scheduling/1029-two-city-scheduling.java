class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // order by savings if I choose b
        Arrays.sort(costs, (p1, p2)-> (p1[0] - p1[1]) - (p2[0] - p2[1]));
        int n = costs.length/2;
        int total = 0;
        for(int[] person : costs){
            if(n-- > 0)
                total += person[0];    
            else
                total += person[1];
        }
        return total;
    }
}