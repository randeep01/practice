package dp;

public class LCS {
    public static void main(String args[]) {
        String s1 = "randeepsingh";
        String s2 = "mandeep";

        int n = s1.length();
        int m = s2.length();

        int memo[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                memo[i][j] = -1;
            }
        }

        int val = lcs(s1, s2, n, m);
        System.out.println(val);

        val = lcsMemo(s1, s2, n, m, memo);
        System.out.println(val);

        val = lcsDP(s1, s2, n, m);
        System.out.println(val);
    }

    public static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
        }
    }

    public static int lcsMemo(String s1, String s2, int n, int m, int[][] memo) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            memo[n][m] = 1 + lcsMemo(s1, s2, n - 1, m - 1, memo);
            return memo[n][m];
        } else {
            memo[n][m] = Math.max(lcsMemo(s1, s2, n, m - 1, memo), lcsMemo(s1, s2, n - 1, m, memo));
            return memo[n][m];
        }
    }

    public static int lcsDP(String s1, String s2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

            }
        }
        return dp[n][m];
    }
}
