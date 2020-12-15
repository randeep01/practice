package dp;

public class PrintLongestCommonSubsequence {
    public static void main(String args[]) {
        String s1 = "randeep";
        String s2 = "maneep";

        int n = s1.length();
        int m = s2.length();

        String lcs = lcs(s1, s2, n, m);
        System.out.println(lcs);
    }

    public static String lcs(String s1, String s2, int n, int m) {
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

        System.out.println("lcs val " + dp[n][m]);

        StringBuilder sLcs = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sLcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }

            }
        }

        return sLcs.reverse().toString();

    }
}
