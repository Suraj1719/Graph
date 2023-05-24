Article : https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/

video : https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45


code :

class Solution{
    static class pair{
        int dis,node;
        pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<pair>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
	    }
	    PriorityQueue<pair> pq=new PriorityQueue<>((x,y)-> x.dis-y.dis);
	    int vis[]=new int[V];
	    pq.add(new pair(0,0));//src , distance
	    int sum=0;
	    while(!pq.isEmpty()){
	        pair cur=pq.peek();
	        pq.remove();
	        int cur_node=cur.node;
	        int distance=cur.dis;
	        if(vis[cur_node]==1)continue;
	        
	        //after check we add distance
	        vis[cur_node]=1;
	        sum+=distance;
	        for(int i=0;i<adj.get(cur_node).size();i++){
	            int nei=adj.get(cur_node).get(i).node;
	            int nei_wt=adj.get(cur_node).get(i).dis;
	            
	            if(vis[nei]==0){
	                pq.add(new pair(nei,nei_wt));
	            }
	        }
	    }
	    return sum;
	}
}
