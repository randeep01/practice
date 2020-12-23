package sliding_window;

public class LargestSubArrayOfSumK {
    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 1, 1, 1, 5 };
        int k = 5; // desired sum

        int res = solve(arr, k);
        System.out.println(res);
    }

    public static int solve(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                max = Math.max(max, (j - i + 1));
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
