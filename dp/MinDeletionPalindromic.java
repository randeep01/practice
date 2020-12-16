package dp;

public class MinDeletionPalindromic {
    public static void main(String args[]){
        String a = "agbcba";
        int minDel = minDeletioPalin( a);
        System.out.println(" Deletion required" + minDel);
    }
    public static int minDeletioPalin(String a){
        StringBuilder sb = new StringBuilder(a);
        String b = sb.reverse().toString();

        int lps = lps(a,b,a.length(),b.length());
        return a.length() - lps;
    }
    public static int lps(String a, String b, int n,int m){
        int dp[][] = new int[n+1][m+1];

        for(int i =0;i<n+1;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] +1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }

        return dp[n][m];
    }
}
