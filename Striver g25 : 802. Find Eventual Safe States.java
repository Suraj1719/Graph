//Using Topological sorting

//Article : https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //topological sort
        int n=graph.length;
        List<List<Integer>> rev_adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            rev_adj.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int nei:graph[i]){
                rev_adj.get(nei).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
            q.add(i);
        }

        List<Integer> safeNodes=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            safeNodes.add(node);
            for(int nei:rev_adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0)
                q.add(nei);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
