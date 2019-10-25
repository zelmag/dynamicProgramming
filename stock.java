/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. */

public class stocks {
    public int maxProfit(int[] prices) {
        int buyIndex=0; //pointer to buy price
        int sellIndex=0; //pointer to sell price
        int maxProfit=0; 
        for(int i=0; i<prices.length; i++){
            if(prices[i]<prices[buyIndex]){ //found a better buy price. Move buy AND sell index
                buyIndex=i;
                sellIndex=i;
            }else if(prices[i]>prices[sellIndex]){ //move sell index
                sellIndex=i;
            }
            if(buyIndex<=sellIndex && prices[sellIndex]-prices[buyIndex] > maxProfit){
                maxProfit=prices[sellIndex]-prices[buyIndex]; //document profit if good
            }
        }
        return maxProfit;
    }
}
