package dp;
// TODO not complete-giving wrong answer
public class PalindromicPartition {
    public static void main(String args[]) {
        String str = "nitik";
        int count = palindromicPartitions(str, 0, str.length() - 1);
        System.out.println(count);
    }

    public static boolean isPalindrome(String str, int i, int j) {
        if(i>=j){
            return true;
        }
        if(i>j) return true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int palindromicPartitions(String str, int i, int j) {

        if (i >= j)
            return 0;
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = palindromicPartitions(str, i, k) + palindromicPartitions(str, k + 1, j) + 1;

            if (temp < min) {
                min = temp;
            }   
        }

        return min;
    }
}
