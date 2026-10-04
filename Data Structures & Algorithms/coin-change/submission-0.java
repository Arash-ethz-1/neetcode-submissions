class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;
        for (int i = 0; i <= amount; i++){
            for (int coin : coins) {
                if (coin > amount) continue;
                int rest = i - coin;
                if (rest < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[rest]);
            }
        }
        int result = dp[amount] == (Integer.MAX_VALUE - 1) ? -1 : dp[amount];
        return result;
    }
}
