public class DutchFlag {
    public static void main(String args[]){
        int arr[] = {2,2,1,1,1,2,0,0,0};
        dutchFlag(2, arr);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + ",");
        }
    }
    public static void dutchFlag(int pivotIndex, int[] arr){
        int smaller = 0;
        int equal = 0;
        int larger = arr.length;

        int pivot = arr[pivotIndex];

        while(equal<larger){
            if(arr[equal]<pivot){
                swap(arr,smaller++,equal++);
            } else if(arr[equal] == pivot){
                ++equal;
            } else { // arr[equal] > pivot
                swap(arr,equal,--larger);
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
