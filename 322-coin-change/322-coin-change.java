// class Solution {
//    private int coinChange_(int[] coins, int tar) {
//         if (tar == 0)
//             return 0;

//         int minCoin = (int) 1e9;
//         for (int coin : coins) {
//             if (tar - coin >= 0)
//                 minCoin = Math.min(minCoin, coinChange_(coins, tar - coin) + 1);
//         }

//         return minCoin;
//     }

//     public int coinChange(int[] coins, int tar) {
//         int ans = coinChange_(coins, tar);
//         return ans != (int) 1e9 ? ans : -1;
//     }
// }


class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        //initialize memo
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, 666);
        memo[0] = 0;
        // record res start from 0 to amount
        for (int i = 0; i < memo.length; i++) {
            for (int coin : coins) {
                // base case 
                if (i - coin < 0) continue;
                memo[i] = Math.min(memo[i], 1 + memo[i - coin]);              
            }
        }
        return (memo[amount] == 666)? -1 : memo[amount]; 
        
        
    }
}