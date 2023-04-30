//Article : https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/


//code  using topological sorting

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort

        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int inorder[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
            inorder[v]++;
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
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

        if(cur.size()!=numCourses){
            return new int[]{};
        }
        int ans[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i]=cur.get(i);
        }

    return ans;   
    }
}
