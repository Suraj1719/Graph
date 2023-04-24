//read article :https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/

//read at gfg

//Note : topological sort possible only on directed acyclic graph

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int vis[]=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0)
            dfs(i,vis,adj,st);
        }
        int ans[]=new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }
    static void dfs(int node,int vis[],ArrayList<ArrayList<Integer>> adj,Stack<Integer>st){
        vis[node]=1;
        
        for(int nei:adj.get(node)){
            if(vis[nei]==0)
            dfs(nei,vis,adj,st);
        }
        st.push(node);
    }
}
