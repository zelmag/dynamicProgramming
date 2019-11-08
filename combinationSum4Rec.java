//Time Limit Exceeded. 
//Depth Seach on tree of possibilities through recursion
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] combs = new int[1];
        help(combs,target,nums);
        return combs[0];
    }
    int help(int[] combs, int target, int[] nums){
        if(target<0){
            return -1;
        }else if(target==0){
            combs[0]=combs[0]+1;
            return 0;
        }else{
            for(int option : nums){
                int tryAdd = help(combs,target-option,nums);
                if(tryAdd<=0){
                    //no use in keep going bc already over or at answer 
                    break;
                }
            }
        }
        return 1;
    }
}
