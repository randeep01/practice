package dp;


public class A2B {
    static public class Tuple<A,B>{
        public A a;
        public B b;
        public Tuple(A a,B b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String args[]){
        String a = "heap";
        String b = "pea";
        Tuple<Integer,Integer> res = minInsertionDeletion(a,b);
        System.out.println("Deletion" + res.a);
        System.out.println("Insertion" + res.b);
    }
    public static  Tuple<Integer,Integer> minInsertionDeletion(String a, String b){
        int lcs = lcs( a,  b,  a.length(),b.length());
        System.out.println("lcs" + lcs);
        int del = a.length() - lcs;
        int insertion = b.length() - lcs ;

        return new Tuple<Integer,Integer>(del,insertion);

    }
    public static  int lcs(String a,String b, int n, int m){
        int dp[][] = new int[n+1][m+1];

        for(int i =0;i<=n;i++){
            for(int j =0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }

                else{
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        return dp[n][m];
        
    }
}
