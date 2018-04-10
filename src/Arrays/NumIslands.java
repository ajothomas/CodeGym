package Arrays;

/**
 * Created by ajothomas on 11/17/17.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water
 */
public class NumIslands {
    public void visitNeighbors(int[][] grid, int i, int j) {
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length) {
            if(grid[i][j]==1) {
                grid[i][j] = 0;
                int mat[][] = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int k=0;k<mat.length;k++)
                    visitNeighbors(grid, i+mat[k][0], j+mat[k][1]);
            }
        }
        return;
    }

    public int numIslands(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    count++;
                    visitNeighbors(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumIslands n = new NumIslands();
        int arr[][]=
                {
                        {1,1,1,1,0},
                        {1,1,0,1,0},
                        {0,0,0,0,0},
                        {1,1,0,0,0}
                };

        System.out.println("Num Islands : "+n.numIslands(arr));
    }
}
