package Arrays;

/**
 * Created by ajothomas on 11/17/17.
 */
public class MaxAreaOfIsland {
    public int findArea(int[][] grid, int i, int j) {
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length) {
            if(grid[i][j]==1) {
                int nMat[][] = {{1,0},{0,1},{-1,0},{0,-1}};
                int tempSum = grid[i][j];
                // mark grid as visited
                grid[i][j] = -1;

                for(int k=0; k<nMat.length; k++)
                    tempSum += findArea(grid, i+nMat[k][0], j+nMat[k][1]);

                return tempSum;
            }
            return 0;
        }
        return 0;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = -1;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1)
                    maxArea = Math.max(maxArea,findArea(grid, i, j));
            }
        }
        if(maxArea==-1)
            return 0;
        return maxArea;
    }

    public static void main(String args[]) {
        MaxAreaOfIsland n = new MaxAreaOfIsland();
        int arr[][]=
                {
                        {1,1,1,1,0},
                        {1,1,0,1,0},
                        {0,0,0,0,0},
                        {1,1,0,0,0}
                };

        System.out.println("Max Area : "+n.maxAreaOfIsland(arr));
    }
}
