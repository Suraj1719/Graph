//Article : https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/

//code : topological sorting

class Solution {
    class pair{
        int first,second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public void topoSort(int node,List<List<pair>>adj,int vis[],Stack<Integer>st){
        vis[node]=1;
        for(pair cur:adj.get(node)){
            int v=cur.first;
            if(vis[v]==0)
            topoSort(v,adj,vis,st);
        }
        st.add(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		List<List<pair>>adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    List<pair>temp=new ArrayList<>();
		    adj.add(temp);
		}
		
		for(int i=0;i<M;i++){
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(u).add(new pair(v,wt));
		}
		
		//toposort using dfs as we do not need to return topo sort sequence
		int vis[]=new int[N];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<N;i++){
		    if(vis[i]==0)
		    topoSort(i,adj,vis,st);
		}
		
		int dist[]=new int[N];
		for(int i=0;i<N;i++){
		    dist[i]=(int)(1e9);
		}
		//source
		dist[0]=0;
		while(!st.isEmpty()){
		    int node=st.peek();
		    st.pop();
		    for(pair cur:adj.get(node)){
		        int v=cur.first;
		        int wt=cur.second;
		        if(dist[node]+wt<dist[v]){
		            dist[v]=dist[node]+wt;
		        }
		    }
		}
		for(int i=0;i<N;i++){
		    if(dist[i]==(int)(1e9))
		    dist[i]=-1;
		}
	return dist;
	}
}
