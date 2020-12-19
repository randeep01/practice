package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NGR {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 3, 5, 25, 50 };
        ArrayList<Integer> ar = ngr(arr);

        for (int val : ar) {
            System.out.print(val + ",");
        }
    }

    public static ArrayList<Integer> ngr(int[] arr) {
        ArrayList<Integer> ret = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                ret.add(-1);
            } else if (st.size() > 0 && st.peek() > arr[i]) {
                ret.add(st.peek());
            } else if (st.size() > 0 && st.peek() <= arr[i]) {
                while (st.size() > 0 && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    ret.add(-1);
                } else {
                    ret.add(st.peek());
                }
            }
            st.push(arr[i]);

        }
        Collections.reverse(ret);
        return ret;
    }
}
