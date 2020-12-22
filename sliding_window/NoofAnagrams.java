package sliding_window;

import java.util.HashMap;
public class NoofAnagrams {
    public static void main(String args[]){
        String str = "abcxacbncbaxx";
        String pattern = "acb";
        int count = noOfAnagrams(str,pattern);
        System.out.println(count);
    }
    public static HashMap<Character,Integer> getPatternMap(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0;i<str.length();i++){

            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            } else {
                map.put(ch,1);
            }
        }
        return map;
    }
    public static int noOfAnagrams(String str, String pattern){
        int n = str.length();
        int k = pattern.length();
        int i = 0;
        int j = 0;
        HashMap<Character,Integer> map = getPatternMap(pattern);
        int count = map.size();

        int result = 0;
        while(j<n){
            char ch = str.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count --;
                }
            }

            if(j-i+1<k){
                j++;
            } else if (j-i+1==k){

                if(count==0){
                    result ++;
                }
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);

                    if(map.get(str.charAt(i))==1){
                        count ++;
                    }

                }
                i++;
                j++;
            }



        }
        return result;
    }
}
