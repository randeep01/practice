package dp;

public class ShortestSuperSequence {
    public static void main(String args[]){
    String s1 ="randeep";
    String s2 ="mandeep";
    int n = s1.length();
    int m = s2.length();

    int val = superSequence(s1,s2,n,m);

    System.out.println(val);
    }
    public static int superSequence(String s1, String s2,int n,int m){
        int superSeqLen = n+m - lcs(s1,s2,n,m);
        return superSeqLen;
    }
    public static int lcs(String s1,String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else {
                    if(s1.charAt(i-1) == s2.charAt(i-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;

                    } else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }

            }
        }

        return dp[n][m];
    }
}
