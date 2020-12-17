package dp;

public class LPSInsertions {
    public static void main(String args[]){
        String s1 = "ranr";
        int noOfInsertions = noOfInsertions(s1);
        System.out.println(noOfInsertions);
    }
    public static int noOfInsertions(String s1){
        int n = s1.length();
        return n - lps(s1,new StringBuilder(s1).reverse().toString(), n, n);


    }
    public static int lps(String s1, String s2, int n, int m){
        System.out.println(s1 + "," + s2);
        int dp[][] = new int [n+1][m+1];
        for(int i =0;i<=n;i++){
            for(int j =0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else {
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
        return dp[n][m];
    }
}
