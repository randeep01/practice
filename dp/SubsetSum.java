package dp;

public class SubsetSum {
    public static void main(String args[]) {
        System.out.println("subset");
        int arr[] = { 1, 3, 5, 6 };
        int sum = 19;
        boolean isPresent = subsetRec(arr, sum, arr.length);
        System.out.println(isPresent);
        isPresent = subsetDP(arr, sum, arr.length);
        System.out.println(isPresent);
    }

    static boolean subsetRec(int[] arr, int sum, int n) {
        if (sum == 0)
            return true;
        if (n == 0) {
            return false;
        }
        if (arr[n - 1] <= sum) {
            return subsetRec(arr, sum - arr[n - 1], n - 1) || subsetRec(arr, sum, n - 1);
        } else {
            return subsetRec(arr, sum, n - 1);
        }
    }

    static boolean subsetDP(int[] arr, int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
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
        return dp[n][sum];
    }
}