package dp;

public class CoinChange {
    public static void main(String args[]) {
        int coins[] = { 1, 2, 3 };
        int total = 15;
        int noOfWays = coinChange(coins, total, coins.length);

        System.out.println(noOfWays);

        noOfWays = coinChangeDP(coins, total, coins.length);

        System.out.println(noOfWays);
    }

    public static int coinChange(int[] coins, int total, int n) {
        if (total == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        } else if (coins[n - 1] <= total) {
            return coinChange(coins, total - coins[n - 1], n) + coinChange(coins, total, n - 1);
        } else {
            return coinChange(coins, total, n - 1);
        }
    }

    public static int coinChangeDP(int[] coins, int total, int n) {
        int dp[][] = new int[n + 1][total + 1];

        for (int i = 0; i <= total; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total; j++) {
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][total];
    }
}
