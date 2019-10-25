/*Find the max sum of sub array of at least 1 item */
import java.util.Scanner;
public class maxSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sizeArray = in.nextInt();
        int[] arr = new int[sizeArray];
        int counter = 0;
        while (counter < sizeArray) {
            arr[counter] = in.nextInt();
        }
        System.out.println(maxSubArray(arr));
    }
    static int maxSubArray (int[] nums) {
        int res=Integer.MIN_VALUE, sum=0;
        for(int i = 0; i<nums.length; i++){ //start corner
            //once the sum goes negative, replace start corner. Else, add current item to interval
            sum= sum<0 ? nums[i]:sum+nums[i];
            res = sum>res? sum : res;
            //keep track of biggest sum thus far, including the smallest negative num if its the case
        }
        return res;
    }
}
