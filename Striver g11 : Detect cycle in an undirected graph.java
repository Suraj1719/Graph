// Solve using Bfs

// question : https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph

//Article : https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/

//code : 

public class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        
        for(int i=0;i<V;i++)
            if(vis[i]==false) 
                if(checkForCycle(adj, i,vis)==true) 
                    return true;
    
        return false;
    }
    boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
            boolean vis[])
    {
       Queue<pair> q =  new LinkedList<>(); //BFS
       q.add(new pair(s, -1));
       vis[s] =true;
       
       // until the queue is empty
       while(!q.isEmpty())
       {
           // source node and its parent node
           int node = q.peek().x;
           int par = q.peek().y;
           q.remove(); 
           
           // go to all the adjacent nodes
           for(Integer it: adj.get(node))
           {
               if(vis[it]==false)  
               {
                   q.add(new pair(it, node));
                   vis[it] = true; 
               }
        
                // if adjacent node is visited and is not its own parent node
               else if(par != it) return true;
           }
       }
       
       return false;
    }
}
