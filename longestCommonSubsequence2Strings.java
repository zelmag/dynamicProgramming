class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int oneLen=text1.length();
        int twoLen=text2.length();
        if(oneLen==0||twoLen==0){
            return 0; //nothing in common. 
        }
        int[][] memo = new int [oneLen+1][twoLen+1]; //to account for "" being 0
        //first row and first col is 0
        for(int i=1; i<=oneLen; i++){
            char target=text1.charAt(i-1);
            for(int j=1; j<=twoLen; j++){
                if(text2.charAt(j-1)==target){
                    //so same. just add 1 to longest subsequence from before
                    //so remove this char and add 1 to the max
                    memo[i][j]=memo[i-1][j-1]+1;
                }
                else{
                    memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
                    //remove either character and take the max
                    //copy len longest subsequence 
                }
            }
        }
        return memo[oneLen][twoLen];
    }
}
                       
