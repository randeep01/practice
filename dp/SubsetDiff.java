package dp;

public class SubsetDiff {
    public static void main(String args[]){
        int arr[ ] = {1,4,5,6};
        int diff = 4;
        int sumArr = 0;
        for(int val:arr){
            sumArr = val + sumArr;
        }
        int sum  = (diff + sumArr)/2;
        System.out.println("Sum" + sum);
        int n  = arr.length;

        int countDiff = subsetDiff(arr,sum,n);

        System.out.println(countDiff);
    }
    public static int subsetDiff(int[] arr, int sum, int n){
        int[][] dp  = new int[n+1][sum+1];
        for(int i =0;i<=sum;i++){
            dp[0][i] = 0;
        }
        for(int i =0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printArr(dp);
        return dp[n][sum];

    }

    static void printArr(int[][] arr){
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
