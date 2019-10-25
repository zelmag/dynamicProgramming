/*Uses Fibonacci numbers. Bottom up approach memoization. takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top? */

public class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            if(n==1){
                return 1; //1
            }else if(n==2){
                return 2; //1+1, 2
            }
        }
        int[] ways = new int[n+1];
        ways[1]=1;
        ways[2]=2;
        for(int i=3; i<=n; i++){
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n];
    }
}
