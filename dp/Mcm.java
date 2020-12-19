package dp;

public class Mcm {
    // static i
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int val = mcm(arr, 1, arr.length - 1);
        System.out.println(val);
    }

    public static int mcm(int[] arr, int i, int j) {
        if (i == j) {
            return 0;

        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = mcm(arr, i, k) + mcm(arr, k + 1, j) + (arr[i - 1] * arr[j] * arr[k]);

            if (temp < min) {
                min = temp;
            }

        }
        return min;
    }
}
