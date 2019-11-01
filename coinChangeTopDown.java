class Solution {
    //Key subproblem minCoins(amt) = min{minCoins(amt-c1),minCoins(amt-c2),minCoins(amt-c3)}+1
    static int[] minCoins;
    public int coinChange(int[] coins, int amount) {
      minCoins = new int [amount+1]; //where I store the min amt of coins for that amount
      return help(amount, coins);
    }
    int help(int amtNow, int[] coins){
        if(amtNow==0){
            return 0;
        }
        if(minCoins[amtNow]!=0){
            return minCoins[amtNow]; //I already put in the answer, read it
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amtNow-coin>=0){ //I can fit this coin 
                int res = help(amtNow-coin, coins);
                if(res>=0 && res!=Integer.MAX_VALUE){
                    if(min>res+1){
                        min=res+1;
                    }
                }
            }
        }
        minCoins[amtNow] = (min == Integer.MAX_VALUE) ? -1 : min;
        return minCoins[amtNow];
    }
}
