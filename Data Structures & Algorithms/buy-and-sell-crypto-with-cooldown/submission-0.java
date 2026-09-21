class Solution {
    public int maxProfit(int[] prices) {
        int hold = 0;
        int sold = 1;
        int rest = 2;
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][hold] = - prices[0];


        for (int i = 1; i < n; i++){
            dp[i][sold] = dp[i-1][hold] + prices[i];
            dp[i][hold] = Math.max(dp[i-1][hold], dp[i-1][rest] - prices[i]);
            dp[i][rest] =  Math.max(dp[i-1][rest], dp[i-1][sold]);
        }

        int result = 0;
        for(int i = 0; i < 3; i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        return result;
    }
}
