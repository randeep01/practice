package dp;

public class SubsetCount {
    public static void main(String[] args) {
        int arr[] = { 5, 9, 3, 7, 2, 4, 6, 8, 10, 12 };
        int sum = 2;
        int count = subsetCountRec(arr, sum, arr.length);
        System.out.println("tejas answer is " + count);
        count = subSetCountDP(arr, sum, arr.length);
        System.out.println(count);
    }

    public static int subsetCountRec(int arr[], int sum, int n) {
        if (sum == 0)
            return 1;
        if (n == 0) {
            return 0;
        } else if (arr[n - 1] <= sum) {
            return subsetCountRec(arr, sum - arr[n - 1], n - 1) + subsetCountRec(arr, sum, n - 1);
        } else {
            return subsetCountRec(arr, sum, n - 1);
        }
    }

    public static int subSetCountDP(int arr[], int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
