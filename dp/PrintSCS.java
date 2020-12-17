package dp;

public class PrintSCS {
    public static void main(String args[]) {
        String a = "randeep";
        String b = "randeep";

        String s = scs(a, b, a.length(), b.length());
        System.out.println(s);
    }

    public static String scs(String a, String b, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

            }
        }

        int i = n;
        int j = m;
        StringBuilder s = new StringBuilder();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                s.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    s.append(a.charAt(i - 1));
                    i--;
                } else {
                    s.append(b.charAt(j - 1));
                    j--;
                }
            }
        }
        while (i > 0) {
            s.append(a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            s.append(b.charAt(j - 1));
            j--;
        }

        return s.reverse().toString();
    }
}
