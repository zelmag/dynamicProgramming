//Iterative solution to jump game. Can you make it to the end?
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false; 
        }
        int furthestReachSoFar = 0;
        for(int i = 0; i < nums.length; i++){
            if(furthestReachSoFar < i){
                return false; //can't reach i. no way to proceed
            }
            furthestReachSoFar = Math.max(furthestReachSoFar, i + nums[i]);
            //furthestReachSoFar = max b/w furthestReach and here + max can jump from here
        }
        return true;
    }
}
