public class OddEven {
    public static void main(String args[]){
        // WAP such that all the even numbers are in begining and all the odd numbers are at end of array
        int arr[] = {1,3,41,2,4,1,4,21,66,32};
        oddEven(arr);

        for(int a:arr){
            System.out.print(a + ",");
        }
    }
    public static void oddEven(int[] arr){
        if(arr==null) return;
        int nextEven = 0;
        int nextOdd = arr.length -1;
        while(nextEven<nextOdd){
            if(arr[nextEven] % 2 == 0){
                nextEven ++;
            } else {
                int temp = arr[nextEven];
                arr[nextEven] = arr[nextOdd];
                arr[nextOdd--] = temp;

            }
        }
    }
}
