class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
       List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        int inorder[]=new int[N];
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
            inorder[v]++;
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(inorder[i]==0)
            q.add(i);
        }

        List<Integer>cur=new ArrayList<>();
        
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            cur.add(node);
            for(int nei:adj.get(node)){
                inorder[nei]--;
                if(inorder[nei]==0)
                q.add(nei);
            }
        }

        if(cur.size()!=N){
            return false;
        }
        

    return true;   
    }
    
}
