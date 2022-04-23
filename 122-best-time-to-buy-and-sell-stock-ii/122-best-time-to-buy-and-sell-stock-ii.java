class Solution {
    public int maxProfit(int[] prices) {
        int index = 1;
        int profit = 0;
        while (index < prices.length){
            if (prices[index - 1] < prices[index]){
                profit += prices[index] - prices[index - 1];         
            }
            index ++;
        }
        return profit;
    }
}