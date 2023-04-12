//DFS approach

//article : https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,vis,adj)==true)
                return true;
                
            }
        }
        return false;
    }
    boolean dfs(int node,int parent,int vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer nei:adj.get(node)){
            if(vis[nei]==0){
                if(dfs(nei,node,vis,adj)==true)
                return true;
            }else if(nei!=parent)
            return true;
        }
        return false;
    }
}
