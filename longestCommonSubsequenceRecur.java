/*Same as longest common subsequence but with a top, down approach. recursive with memoization */
class Solution {
    static int[][] memo;
    String one;
    String two;
    
    public int longestCommonSubsequence(String text1, String text2) {
        memo=new int[text1.length()+1][text2.length()+1];
        one=text1;
        two=text2;
        for(int i=1; i<=one.length(); i++){
            for(int j=1; j<=two.length(); j++){
                memo[i][j] = -1;
            }
        }
        return help(text1.length(), text2.length());
    }
    int help(int atTxt1, int atTxt2){
        if(memo[atTxt1][atTxt2]!=-1){
            return memo[atTxt1][atTxt2];
        }
        if(one.charAt(atTxt1-1) == two.charAt(atTxt2-1)){
            //if same, add 1 to previous strings being considered
            memo[atTxt1][atTxt2] = 1+help(atTxt1-1, atTxt2-1);
            return memo[atTxt1][atTxt2];
        }else{
            //not equal so return max of either strings
            memo[atTxt1][atTxt2] = Math.max(help(atTxt1-1,atTxt2),help(atTxt1,atTxt2-1));
            return memo[atTxt1][atTxt2];
        }
    }
}
       
