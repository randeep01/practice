package sliding_window;

public class MaxSumInSlidingWindow {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 42, 4, 5, 24, 52, 6, 21 };
        int k = 3; // window size;

        int maxSum = eval(arr, k);

        System.out.println(maxSum);
    }

    public static int eval(int[] arr, int k) {

        int sum = 0;
        int i = 0;
        int j = 0;
        int n = arr.length;
        int max = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return max;

    }
}
