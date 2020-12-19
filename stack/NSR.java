package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
public class NSR {

    public static void main(String args[]){
        int[] arr = {1,3,42,4,2,1};
        ArrayList<Integer> result = nsr(arr);

        for(int val:result){
            System.out.print(val + ", ");
        }

    }
    public static ArrayList<Integer> nsr(int[] arr){
        if(arr==null) 
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(st.size()==0){
                res.add(-1);
            } else if(st.size()>0 && arr[i]>st.peek()) {
                res.add(st.peek());
            } else if (st.size()>0 && arr[i] <= st.peek()){
                while(st.size()>0 && arr[i]<=st.peek()){
                    st.pop();
                }
                if(st.size()==0){
                    res.add(-1);
                }
                else{
                    res.add(st.peek());
                }
           
            }
            st.push(arr[i]);
        }

        Collections.reverse(res);
        return res;

    }
    
}
