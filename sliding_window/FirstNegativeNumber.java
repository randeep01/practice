package sliding_window;

import java.util.ArrayList;

public class FirstNegativeNumber {
    public static void main(String arg[]) {
        int[] arr = { -1, -2, 3, 5, 2, -4, -5, -3 };
        int k = 3;
        int[] res = findNeg(arr, k);

        for (int val : res) {
            System.out.print(val + ", ");
        }
    }

    public static int[] findNeg(int arr[], int k) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[n - k + 1];
        int l = 0;
        while (j < n) {
            if (arr[j] < 0) {
                list.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (list.size() > 0) {
                    res[l] = list.get(0);
                    l++;
                } else {
                    res[l] = 0;
                    l++;
                }
                if (arr[i] < 0) {
                    if (arr[i] == list.get(0)) {
                        list.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
