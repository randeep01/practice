package dp;

public class LongestRepeatingSubsequence {
    public static void main(String arg[]) {
        String s = "abbchcda";
        int lrs = lrs(s, s, s.length(), s.length());
        System.out.println(lrs);
        lrs = lrsDP(s, s, s.length(), s.length());
        System.out.println(lrs);
    }

    public static int lrs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        } else {
            if (s1.charAt(n - 1) == s2.charAt(m - 1) && n != m) {
                return 1 + lrs(s1, s2, n - 1, m - 1);
            } else {
                return Math.max(lrs(s1, s2, n - 1, m), lrs(s1, s2, n, m - 1));
            }
        }
    }

    public static int lrsDP(String s1, String s2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                else {

                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
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
