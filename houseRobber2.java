//Find max amount of money you can rob but 1st and last are considered neighbors. 
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int withFirst = findMaxMoney(Arrays.copyOfRange(nums,0,nums.length-1)); //get max with First, without last
        int withLast = findMaxMoney(Arrays.copyOfRange(nums,1,nums.length)); //get max without First, with last
        return Math.max(withFirst,withLast);
    }
    public int findMaxMoney(int[] nums){
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            money[i] = Math.max(money[i-1], nums[i]+money[i-2]);
        }
        return money[nums.length-1];
    }
}
