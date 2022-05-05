class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] != '0'){
                dp[i][0] = 1;
                res = 1;
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] != '0'){
                dp[0][i] = 1;
                res = 1;
            }
        }


        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] != '0'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res * res;
    }
}