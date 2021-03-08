package stack;
import java.util.ArrayList;
import java.util.Stack;
public class StockSpan {
    static class Tuple<A,B>{
        public A a;
        public B b;
    
        public Tuple(A a,B b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String args[]){
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> res = stockSpan(arr);
        for(int val:res){
            System.out.print(val + ",");
        }
    }
    public static ArrayList<Integer> stockSpan(int arr[]){
       ArrayList<Integer> res = new ArrayList<>();
       Stack<Tuple<Integer,Integer>> st = new Stack<>(); //a = arr[i] , b = i
       
       for(int i =0;i<arr.length;i++){
            if(st.empty()) res.add(-1);
            if(st.size()>0 && st.peek().a >arr[i]) res.add(st.peek().b);
            if(st.size()>0 && st.peek().a <= arr[i]){
                while(st.size()>0 && st.peek().a <=arr[i]){
                    st.pop();
                }
                if(st.size()==0) res.add(-1);
                else res.add(st.peek().b);
            }
            st.push(new Tuple<Integer,Integer>(arr[i],i));
       }
       for(int i =0;i<res.size();i++){
           res.set(i,i - res.get(i));
       }
       return res;
    }
}
