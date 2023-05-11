Article :https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/

code : 
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)(1e8);
        }
        dist[S]=0;
        for(int i=1;i<V;i++){//v-1 times
            for(ArrayList<Integer>cur:edges){
                int u=cur.get(0);
                int v=cur.get(1);
                int wt=cur.get(2);
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        //check vth time
        for(ArrayList<Integer>cur:edges){
            int u=cur.get(0);
            int v=cur.get(1);
            int wt=cur.get(2);
            if(dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
