//read article : https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/


class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        int path[]=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfsCheck(i,adj,vis,path)==true)
                return true;
            }
        }
        return false;
    }
    boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int path[]){
        vis[node]=1;
        path[node]=1;
        
        for(int nei:adj.get(node)){
            if(vis[nei]==0){
                if(dfsCheck(nei,adj,vis,path)==true)
                return true;
            }else if(path[nei]==1)//visited and in same path
            return true;
        }
        
        //remove from cur path
        path[node]=0;
        return false;
    }
}
