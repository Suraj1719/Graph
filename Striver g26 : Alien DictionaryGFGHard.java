//Article : https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/

//leeetcode premium question (important)

//code  (opological sort)

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int j=0;j<N-1;j++){
            String s1=dict[j];
            String s2=dict[j+1];
            
            int len=Math.min(s1.length(),s2.length());
            for(int i=0;i<len;i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    adj.get(s1.charAt(i)-'a').add(s2.charAt(i)-'a');
                    break;
                }
            }
        }
        
        List<Integer>res=TopoSort(K,adj);
        String ans="";
        for(int x:res){
            ans=ans+(char)(x+(int)('a'));
        }
        return ans;
    }
    List<Integer> TopoSort(int k,List<List<Integer>> adj){
        int inorder[]=new int[k];
        for(int i=0;i<k;i++){
            for(int nei:adj.get(i)){
                inorder[nei]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(inorder[i]==0)
            q.add(i);
        }
        List<Integer> ans=new ArrayList<>();
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
    return ans;
    }
}
