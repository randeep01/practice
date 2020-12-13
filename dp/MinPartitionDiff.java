package dp;

public class MinPartitionDiff {
    public static void main(String args[]) {
        int arr[] = { 3, 7, 10 };
        int val = minimizePartion(arr);
        System.out.println(val);
    }

    public static int minimizePartion(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum = sum + val;
        }
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ret = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n][i] == true) {
                ret = sum - 2 * i;
                break;
            }
        }
        return ret;
    }
}
