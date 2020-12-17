package dp;

public class PatternSequenceMatching {
    public static void main(String args[]) {
        String s1 = "xyz";
        String s2 = "anxdhrydsdz";

        boolean isAvail = patternMatching(s1, s2, s1.length(), s2.length());
        System.out.println(isAvail);
    }

    public static boolean patternMatching(String s1, String s2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }

                }

            }
        }
        System.out.println(dp[n][m] + ", " + n);

        if (dp[n][m] == n)
            return true;
        return false;
    }
}