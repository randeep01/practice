package dp;
public class Knapsack{
    public static void main(String args[]){
        System.out.println("knapsack");

        int val[] = {60,100,120};
        int wt[] = {10,20,30};
        int n = 3;
        int W = 50;
        int memo[][] = initiateMemo(n, W);
        int maxProfit = knapsackMem(val,wt,n,W,memo);
        System.out.println(maxProfit);
        maxProfit = knapsackDP(val, wt, n, W);
        System.out.println(maxProfit);
 
    }
    public static int knapsackMem(int[] val, int[] wt, int n, int W, int[][]memo){
        if (n==0 || W==0){
            return 0;
        }
        if(memo[n][W]!=-1){
            return memo[n][W];
        }
        if(wt[n-1]<=W){
            memo[n][W] = Math.max(val[n-1] + knapsackMem(val, wt, n-1, W-wt[n-1], memo),knapsackMem(val, wt, n-1, W, memo));
            return memo[n][W];
        }
        else{
            memo[n][W] = knapsackMem(val, wt, n-1, W, memo);
            return memo[n][W];
        }
    }
    public static int knapsackDP(int val[], int wt[], int n, int W){
        int[][]dp = new int[n+1][W+1];
        for(int i =0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
             
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static int[][] initiateMemo(int n, int W)
    {
        int [][] temp = new int[n+1][W+1];
        for(int i =0;i<=n;i++){
            for(int j =0;j<=W;j++){
                temp[i][j] = -1;
            }
        }
        return temp;
    }
}