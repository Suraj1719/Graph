//article : https://takeuforward.org/graph/bipartite-graph-bfs-implementation/

//code (simple brute force)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(check(i,n,graph,color)==false)
                return false;
            }
        }
    return true;
    }
    boolean check(int start,int n,int[][] graph,int color[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int nei:graph[node]){
                if(color[nei]==-1){
                    color[nei]=1-color[node];
                    q.add(nei);
                }else if(color[node]==color[nei])
                return false;
            }
        }
        return true;
    }
}
