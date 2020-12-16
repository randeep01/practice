package dp;

public class LongestPalindromicSubsequence {
    public static void main(String args[]){
        String a = "abdea";
        int lenLongestPlalindromicSubsequence = lps(a);
        System.out.println(lenLongestPlalindromicSubsequence);
    }
    public static int lps(String a){
        StringBuilder sb = new StringBuilder(a);
        String b = sb.reverse().toString();
        int lcs = lcs(a,b,a.length(), b.length());

        return lcs;
    }
    public static int lcs(String a,String b, int n,int m){
        int dp[][] = new int[n+1][m+1];

        for(int i =0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            
        }
        return dp[n][m];
    }
}
