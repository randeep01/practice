public class DutchFlag3Pointer {
    public static void main(String args[])
    {
        int arr[] = {1,2,1,2,0,0,0,0,2};
        dutchflag(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + ",");
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void dutchflag(int arr[]){
        int low = 0;
        int mid = 0;
        int high = arr.length -1;

        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,mid,high);
                    high--;
                    break;
            }
        }
    }
}
