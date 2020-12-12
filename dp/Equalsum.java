package dp;

public class Equalsum {
    public static void main(String args[]){
        int arr[] = {120,5,4,11};
        boolean isEqualSum = equalSum(arr);
        System.out.println(isEqualSum);
        isEqualSum = equalsumDP(arr);
        System.out.println(isEqualSum);
    }
    public static boolean equalsumDP(int [] arr){
        int sum = 0;
        for(int val:arr){
            sum = val+ sum ;
        }
        if(sum % 2!=0){
            return false;
        }
        int n = arr.length;
        int target = sum/2;

        boolean[][]dp = new boolean[n+1][target+1];
        for(int i =0;i<=target;i++){
            dp[0][i] = false;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];

    }
    public static boolean equalSum(int[] arr){
        int sum = 0;
        for(int val:arr){
            sum = sum + val;
        }
        if(sum%2!=0){
            return false;
        }
        return equalSumUtil(arr,sum/2,arr.length);
    }
    public static boolean equalSumUtil(int[] arr,int sum,int n){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        else if(arr[n-1]<=sum){
            return equalSumUtil(arr,sum-arr[n-1],n-1) || equalSumUtil(arr,sum,n-1);
        }else{
            return equalSumUtil(arr,sum,n-1);
        }
    }
}
