package dp;

public class RodCutting {
    public static void main(String args[]) {
        int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int val[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int L = 8;
        int n = len.length;

        int maxProfit = rodCutting(len, val, n, L);

        System.out.println(maxProfit);

        maxProfit = rodCuttingDP(len, val, n, L);
        System.out.println(maxProfit);
    }

    public static int rodCutting(int[] len, int[] val, int n, int L) {
        if (n == 0) {
            return 0;
        }
        if (L == 0) {
            return 0;
        }
        if (len[n - 1] <= L) {
            return Math.max(val[n - 1] + rodCutting(len, val, n, L - len[n - 1]), rodCutting(len, val, n - 1, L));
        } else {
            return rodCutting(len, val, n - 1, L);
        }
    }

    public static int rodCuttingDP(int len[], int[] val, int n, int L) {
        int dp[][] = new int[n + 1][L + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= L; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                else if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][L];
    }
}
