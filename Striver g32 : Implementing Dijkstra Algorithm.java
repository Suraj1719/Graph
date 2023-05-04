//Implement using priority queue  

//NOTE : This algorithm can not be used in graph containing negetive weighted edge 

//code

class Solution
{
    static class Pair{
        int node,distance;
        Pair(int distance,int node){
            this.distance=distance;
            this.node=node;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.distance - b.distance);
        q.add(new Pair(0,s));
        int dist[]=new int[v];
        Arrays.fill(dist,10000000);
        dist[s]=0;
        while(q.size()!=0){
            Pair cur=q.peek();
            int dis=cur.distance;
            int node=cur.node;
            q.remove();
            
            ArrayList<ArrayList<Integer>> neighbors=adj.get(node);
            for(ArrayList<Integer> list:neighbors){
                int adjNode=list.get(0);
                int edge_wt=list.get(1);
                if(dist[adjNode]>dist[node]+edge_wt){
                    dist[adjNode]=dist[node]+edge_wt;
                    q.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        return dist;
    }
}
