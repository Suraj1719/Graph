//leetcode : 1020. Number of Enclaves

class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        //here we can not count one which are at boundary or connect to boundary
        //so we can use bfs on boundary ones

        for(int col=0;col<m;col++){
            //first row
            if(grid[0][col]==1 && vis[0][col]==0)
            bfs(0,col,vis,grid);

            //last row
            if(grid[n-1][col]==1 && vis[n-1][col]==0)
            bfs(n-1,col,vis,grid);
        }

        for(int row=0;row<n;row++){
            //first row
            if(grid[row][0]==1 && vis[row][0]==0)
            bfs(row,0,vis,grid);

            //last row
            if(grid[row][m-1]==1 && vis[row][m-1]==0)
            bfs(row,m-1,vis,grid);
        }
        int total_land=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                total_land++;
            }
        }
        return total_land;
    }
    void bfs(int r,int c,int vis[][],int grid[][]){
        vis[r][c]=1;

        int row_move[]={1,0,-1,0};
        int col_move[]={0,-1,0,1};

        for(int i=0;i<4;i++){
            int new_r=r+row_move[i];
            int new_c=c+col_move[i];
            if(new_r>=0 && new_r<grid.length && new_c>=0 && new_c<grid[0].length && 
               grid[new_r][new_c]==1 && vis[new_r][new_c]==0)

               bfs(new_r,new_c,vis,grid);
        }
    }
}
