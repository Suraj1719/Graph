class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int inorder[]=new int[n];
        for(int i=0;i<m;i++){
            ArrayList<Integer>cur=prerequisites.get(i);
            int u=cur.get(1);
            int v=cur.get(0);
            adj.get(u).add(v);
            inorder[v]++;
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0)
            q.add(i);
        }

        List<Integer>ans=new ArrayList<>();
        
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);
            for(int nei:adj.get(node)){
                inorder[nei]--;
                if(inorder[nei]==0)
                q.add(nei);
            }
        }

        if(ans.size()!=n){
            return new int[]{};
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=ans.get(i);
        }

    return res;   
    }
}
