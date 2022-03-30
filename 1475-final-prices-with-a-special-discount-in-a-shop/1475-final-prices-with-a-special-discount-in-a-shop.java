class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> st = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            while (!st.isEmpty() && st.peek()[0] >= cur) {
                int[] temp = st.pop();

                prices[temp[1]] -= cur;
            }
            st.push(new int[] {cur, i});
        }
        return prices;
    }
}