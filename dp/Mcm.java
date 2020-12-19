package dp;

public class Mcm {
    // static i
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int val = mcm(arr, 1, arr.length - 1);
        System.out.println(val);
        int size = arr.length;
        int[][] memo = new int[size][size];

        for(int i =0;i<size;i++){
            for(int j=0;j<size;j++){
                memo[i][j] = -1;
            }
        }

        val = mcmMemo(arr,1,size-1,memo);

        System.out.println(val);
    }
    public static int mcmMemo(int[]arr, int i, int j, int[][] memo){
        if(i==j){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;

        for(int k = i;k<j;k++){
            int temp = mcmMemo(arr,i,k,memo) + mcmMemo(arr,k+1,j,memo) + (arr[i-1] * arr[j]*arr[k]);

            if(temp<min){
                min = temp;
            }
        }
        return (memo[i][j] = min);


    }
    public static int mcm(int[] arr, int i, int j) {
        if (i == j) {
            return 0;

        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = mcm(arr, i, k) + mcm(arr, k + 1, j) + (arr[i - 1] * arr[j] * arr[k]);

            if (temp < min) {
                min = temp;
            }

        }
        return min;
    }


}
