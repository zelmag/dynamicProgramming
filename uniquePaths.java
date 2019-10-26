/*Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][]ways = new int[n][m]; //ways to get to that block
        for(int c=0; c<ways[0].length; c++){
            ways[0][c] = 1; //fill first row with 1s bc you can only go right
        }
        for(int r=1; r<ways.length; r++){
            ways[r][0] = 1; //fill first col with 1s bc can only go left
        }
        for(int r=1; r<ways.length; r++){
            for(int c=1; c<ways[0].length; c++){
                ways[r][c]=ways[r-1][c]+ways[r][c-1]; //add ways from left and up
            }
        }
        return ways[n-1][m-1];
    }
}
