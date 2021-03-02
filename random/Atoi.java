public class Atoi {
    public static void main(String args[]){
        System.out.println(atoi("-12"));
    }
    public static int atoi(String str) {
        if(str==null || str.equals("")) return 0;
        int sign = 1;
        int idx = 0;

        if(str.charAt(idx)=='-'){
            sign = -1;
            idx ++;
        }
        int res = 0;
        for(;idx<str.length();idx++){
            res = res*10 + (str.charAt(idx) - '0'); 
        }
        return sign*res;
    }
}
