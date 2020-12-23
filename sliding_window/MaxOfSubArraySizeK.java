package sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSubArraySizeK {

    public static void main(String args[]) {
        int arr[] = { 1, 3, 1, 5, -2, 2, -3, 2 };
        int k = 3;
        ArrayList<Integer> result = findMaxInWindow(arr, k);

        for (int val : result) {
            System.out.print(val + ",");
        }
    }

    public static ArrayList<Integer> findMaxInWindow(int[] arr, int k) {
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        int n = arr.length;

        while (j < n) {
            while (q.size() > 0 && q.peekLast() < arr[j]) {
                q.pollLast();
            }
            q.offer(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                int max = q.peek();
                res.add(max);

                if (arr[i] == q.peek()) {
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
