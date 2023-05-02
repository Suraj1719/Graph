//Article : https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/

//code : simple bfs traversal 

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            
        }
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int nei:adj.get(node)){
                if(dist[node]+1<dist[nei]){
                    dist[nei]=dist[node]+1;
                    q.add(nei);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dist[i]==(int)(1e9))
            dist[i]=-1;
        }
    return dist;
    }
}
