//leeetcode : (premium question)  Leetcode 694

//gfg available

//For intution and better under stand see this : https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
//code : 

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Set<ArrayList<String>>res=new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String>cur=new ArrayList<>();
                    dfs(i,j,grid,vis,cur,i,j);
                    res.add(cur);
                }
            }
        }
        return res.size();
    }
    
    void dfs(int r,int c,int grid[][],int vis[][],ArrayList<String>cur,int r_b,int c_b){
        vis[r][c]=1;
        cur.add(toString(r-r_b,c-c_b));
        int n=grid.length;
        int m=grid[0].length;
        
        int row_move[]={1,0,-1,0};
        int col_move[]={0,-1,0,1};
        
        for(int i=0;i<4;i++){
            int new_r=r+row_move[i];
            int new_c=c+col_move[i];
            
            if(new_r>=0 && new_r<n && new_c>=0 && new_c<m && vis[new_r][new_c]==0 &&
                                                             grid[new_r][new_c]==1){
                dfs(new_r,new_c,grid,vis,cur,r_b,c_b);                                                 
            }
        }
    }
    String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
}
