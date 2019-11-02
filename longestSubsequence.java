class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] memo = new int[nums.length];
        memo[0]=1; //longest subsequence is itself 
        int max=1;
        for(int j=1; j<nums.length; j++){
            memo[j]=1;
            for(int endSeq=0; endSeq<j; endSeq++){
                if(nums[j]>nums[endSeq]){
                    //okay so I can extend the sequence previous to me
                    if(memo[endSeq]+1>memo[j]){
                        memo[j]=memo[endSeq]+1;
                        if(memo[j]>max){
                            max=memo[j];
                        }
                    }
                }
            }
        }
        return max;
    }
}
