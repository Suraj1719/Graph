class Solution {
    public static boolean isCyclic(int n, List<List<Integer>>adj) {
        //topological sort

        
     int inorder[]=new int[n];
        for(int i=0;i<n;i++){
           for(int nei:adj.get(i))
             inorder[nei]++;
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
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

        if(cur.size()!=n){
            return true;     //contains cycle
        }
        

    return false;   //not contains cycle
    }
}
