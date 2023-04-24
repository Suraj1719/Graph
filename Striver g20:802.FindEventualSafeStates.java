//read article : https://takeuforward.org/data-structure/find-eventual-safe-states-dfs-g-20/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int vis[]=new int[n];
        int path[]=new int[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,path,check);
            }
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1)
            safeNodes.add(i);
        }
        return safeNodes;
    }
    boolean dfs(int node,int graph[][],int vis[],int path[],int check[]){
        vis[node]=1;
        path[node]=1;
        check[node]=0;

        for(int nei:graph[node]){
            if(vis[nei]==0){
                if(dfs(nei,graph,vis,path,check)==true)//cycle is present
                return true;
            }else if(path[nei]==1)
            return true;
        }

        check[node]=1;
        path[node]=0;
        return false;
    }
}
