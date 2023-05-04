//Article : https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/

//code :

class Solution {
    static class pair{
        int first,second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
       
       List<List<pair>>adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
           adj.add(new ArrayList<>());
       }
       
       for(int i=0;i<m;i++){
           adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
           adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
       }
       
       PriorityQueue<pair>pq=new PriorityQueue<>((x,y)->x.first-y.first);
       int dist[]=new int[n+1];
       int parent[]=new int[n+1];
       for(int i=1;i<=n;i++){
           dist[i]=(int)(1e9);
           parent[i]=i;
       }
       dist[1]=0;//source
       pq.add(new pair(0,1));
       
       while(pq.size()!=0){
           pair cur=pq.peek();
           int node=cur.second;
           int wt=cur.first;
           pq.remove();
           for(pair p:adj.get(node)){
               int adjNode=p.first;
               int adjWt=p.second;
               if(wt+adjWt<dist[adjNode]){
                   dist[adjNode]=wt+adjWt;
                   pq.add(new pair(dist[adjNode],adjNode));
                   parent[adjNode]=node;
               }
           }
       }
       List<Integer>path=new ArrayList<>();
       if(dist[n]==(int)(1e9)){
           path.add(-1);
           return path;
       }
    //   for(int i=1;i<=n;i++){
    //       System.out.print(parent[i]);
    //   }
    //   System.out.println();
       int node=n;
       while(parent[node]!=node){
           path.add(node);
           node=parent[node];
       }
       path.add(1);
       Collections.reverse(path);
       return path;
       
    }
}
