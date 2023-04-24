//DFS traversal

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        //DFS traversal
        int color[]=new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,adj,color,0)==false)
                return false;
            }
        }
    return true;
    }
    boolean dfs(int node, ArrayList<ArrayList<Integer>>adj,int color[],int col){
        color[node]=col;
        for(int nei:adj.get(node)){
            if(color[nei]==-1){
                if(dfs(nei,adj,color,1-col)==false)
                return false;
            }else if(color[nei]==col)//color[nei]==color[node]
            return false;
        }
        return true;
    }
}
