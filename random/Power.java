public class Power {
    public static void main(String args[]){
        System.out.println(power(2,3));
    }
    public static double power(int n, int p){
        if(p < 0){
            return 1/powerUtil(n,p);
        }else{
            return powerUtil(n,p);
        }
    }
    public static double powerUtil(int n,int p){
        if(p==0) return 1;
        double temp = powerUtil(n, p/2);
        if(p%2==0){
            return temp*temp;
        }
        return temp*temp *n;
    }
}
