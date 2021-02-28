public class WaterTrapping {
    public static void main(String args[]){
        int arr[] = {5,0,6};
        int vol = waterTrapping(arr);
        System.out.println(vol);
    }
    public static int waterTrapping(int arr[]){
        if(arr==null) return 0;
        int rMax[] = new int[arr.length];
        int lMax[] = new int[arr.length];
        lMax[0] = arr[0];
        for(int i =1;i<arr.length;i++){
            lMax[i] = Math.max(lMax[i-1],arr[i]);
        }
        rMax[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+i],arr[i]);
        }
        int res = 0;
        for(int i =1;i<arr.length-1;i++){
            res = res + (Math.min(lMax[i],rMax[i]) - arr[i]);
        }
        return res;
    }
}
