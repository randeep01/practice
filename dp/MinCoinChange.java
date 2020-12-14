package dp;

public class MinCoinChange {
    private static int INF = Integer.MAX_VALUE - 1;

    public static void main(String args[]) {
        int coins[] = { 1, 2, 5 };
        int val = 14;

        int minCoins = minCoinChange(coins, val, coins.length);

        System.out.println(minCoins);

        minCoins = minCoinChange(coins, val, coins.length);

        System.out.println(minCoins);

    }

    public static int minCoinChange(int[] coins, int val, int n) {
        if (n == 0)
            return INF;
        if (val == 0) {
            return 0;
        } else if (coins[n - 1] <= val) {
            return Math.min(1 + minCoinChange(coins, val - coins[n - 1], n), minCoinChange(coins, val, n - 1));
        } else {
            return minCoinChange(coins, val, n - 1);
        }
    }

    public static int minCoinChangeDP(int[] coins, int val, int n) {
        int dp[][] = new int[n + 1][val + 1];
        for (int i = 0; i <= val; i++) {
            dp[0][i] = INF;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= val; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[n][val];
    }
}
