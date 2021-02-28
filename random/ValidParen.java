import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
public class ValidParen{
    public static void main(String args[]){
        System.out.println(bal(")()"));
    }
    public static int isValid(String str){
        int val = 0;
		for(int i = 0;i<str.length();i++)
		{
			if(str.charAt(i) == ')'){
				val--;
				if(val<0)
					return val;
			}
			else if(str.charAt(i) == '('){
				val++;
			}
			else{
                //val = val;
                ;
			}

		}

		return val;
	
    }
    public static String bal(String str){
        if(str==null) return null;
        if(isValid(str) == 0) return str;
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.add(str);
        hs.add(str);
        while(q.isEmpty()!=true){
            String val = q.poll();
            if(isValid(val)==0) return val;
            for(int i =0;i<val.length();i++){
                String temp = val.substring(0, i) + val.substring(i+1);
                if(hs.contains(temp) == false){
                    q.add(temp);
                    hs.add(temp);
                }
            }
        }
        return null;
    }
}