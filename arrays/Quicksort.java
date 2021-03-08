
public class Quicksort {
    public static void main(String args[]){
        int arr[] = {1,3,3,2,3,24,2,5,2,4,Integer.MAX_VALUE};
        quickSort(arr);
        for(int a:arr){
            System.out.print(a + ",");
        }
    }
    static void quickSort(int arr[]){
        qsUtil(arr,0,10);
    }
    static void qsUtil(int arr[], int l, int h){
        if(l<h){
            int p = partition(arr,l,h);
            qsUtil(arr,l,p);
            qsUtil(arr,p+1,h);
        }
    }
    static int partition(int[] arr, int l, int h){
        int pivot = arr[l];
        int i = l;
        int j = h;
        do{
            do{ i++;} while(pivot>=arr[i]);
            do{ j--;} while(pivot<arr[j]);
            if(i<j) swap(arr,i,j);
        }while(i<j);
        swap(arr,l,j);
        return j;
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
