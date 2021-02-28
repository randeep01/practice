import java.util.*;
public class StringCombi {
    public static void main(String args[]){
        combi("randeep");
    }
    public static void combi(String str){
        if(str == null || str.equals("")){
            return;
        }
        Queue<String> q = new java.util.LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.add(str);
        hs.add(str);
        while(!q.isEmpty()){
            String val = q.poll();
            System.out.println(val);

            for(int i =0;i<val.length();i++){
                String temp = val.substring(0,i) + val.substring(i+1);
                if(!hs.contains(temp)){
                    q.add(temp);
                    hs.add(temp);
                }
            }
        }


    }
}
