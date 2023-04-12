//GFG question 
//article : https://takeuforward.org/graph/distance-of-nearest-cell-having-1/

//Note : here we use bfs traversal as we need to give min distance of 1 for all 0


class Solution
{
    class pair{
        int x;
        int y;
        int step;
        pair(int x,int y,int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int dis[][]=new int[n][m];
        
        Queue<pair>q=new LinkedList<>();//row,col, step
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int row=q.peek().x;
            int col=q.peek().y;
            int st=q.peek().step;
            
            q.poll();
            dis[row][col]=st;
            
            int row_mov[]={1,0,-1,0};
            int col_mov[]={0,-1,0,1};
            
            for(int i=0;i<4;i++){
                int nrow=row+row_mov[i];
                int ncol=col+col_mov[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    q.add(new pair(nrow,ncol,st+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        return dis;
    }
}
