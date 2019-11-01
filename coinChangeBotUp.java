class Solution {
    //Key subproblem minCoins(amt) = min{minCoins(amt-c1),minCoins(amt-c2),minCoins(amt-c3)}+1
    public int coinChange(int[] coins, int amount) {
        //bottom up approach
        int minCoins[] = new int [amount+1];
        //0 coins to get to amt 0. 
        for(int amt=1;amt<minCoins.length; amt++){
            //fill the minCoins array with placeholder values
            minCoins[amt]=Integer.MAX_VALUE;
            for(int choices=0; choices<coins.length; choices++){
                //loop through your coins for each amount and see if its less to use that coin
                if(amt-coins[choices]>=0 && minCoins[amt-coins[choices]]!=Integer.MAX_VALUE){
                    //so this coin fits first of all
                    minCoins[amt]=Math.min(minCoins[amt],minCoins[amt-coins[choices]]+1);
                }
            }
        }
        return minCoins[amount]==Integer.MAX_VALUE ? -1: minCoins[amount];
    }
}
