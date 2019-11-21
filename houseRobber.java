//police called if 2 adjacent houses are robbed 
//max amt of money you can rob 
//which one to rob. this one or the previous. Max Exclusive or money 
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0],nums[1]); //can choose 1st house or 2nd house
        for(int i = 2; i < nums.length; i++){
            //can either do 1 and 3 or 2
            money[i] = Math.max(nums[i]+money[i-2],money[i-1]);
        }
        return money[nums.length-1];
    }
}
