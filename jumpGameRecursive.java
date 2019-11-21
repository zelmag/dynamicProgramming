//Recursive solution to jump game. Can you make it to the end?
class Solution {
    public boolean canJump(int[] nums) {
        return help(0,nums, new boolean[nums.length]);
    }
    
    public boolean help(int indexAt,int[] nums, boolean[] deadEnds){
        if(indexAt == nums.length-1){
            return true;
        }else if(deadEnds[indexAt]){
            return false; 
        }
        else if(nums[indexAt] == 0){
            //you are stuck and cant move forward
            deadEnds[indexAt] = true;
            return false;
        }
        int maxJumps = nums[indexAt];
        for(int i=1; i<=maxJumps; i++){
            if(!deadEnds[indexAt+i]){
                if(help(indexAt+i,nums,deadEnds)){
                    return true;
                }else{
                    deadEnds[indexAt+i] = true;
                }
            }
        }
        return false; 
    }
}
