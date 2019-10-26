/*Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right */ 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][]ways = new int[obstacleGrid.length][obstacleGrid[0].length]; //ways to get to that block
        for(int c=0; c<ways[0].length; c++){
            if(obstacleGrid[0][c]==1){
                ways[0][c] = 0;
                break; //exit out of loop bc rest of row will be zero as well 
            }else{
                ways[0][c] = 1; //fill first row with 1s bc you can only go right
            }
        }
        for(int r=1; r<ways.length; r++){
             if(obstacleGrid[r][0]==1 || obstacleGrid[r-1][0]==1){
                ways[r][0] = 0;
                break;
             }else{
                ways[r][0] = 1; //fill first col with 1s bc can only go left
             }
        }
        for(int r=1; r<ways.length; r++){
            for(int c=1; c<ways[0].length; c++){
                if(obstacleGrid[r][c]==1){
                    ways[r][c]=0;
                }else{
                    ways[r][c]=ways[r-1][c]+ways[r][c-1]; //add ways from left and up
                }
            }
        }
        return ways[ways.length-1][ways[0].length-1];
    }
}
