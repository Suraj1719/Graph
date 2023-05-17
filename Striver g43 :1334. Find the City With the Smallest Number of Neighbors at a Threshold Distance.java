Article : https://takeuforward.org/data-structure/find-the-city-with-the-smallest-number-of-neighbours-at-a-threshold-distance-g-43/

code :
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      
        //this can be done using dijkstra algo and we have to calculate for every node

        //here we use floydwarshal alogo , and it give a 2d matrix
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=1000000;
            }
        }
        int m=edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int i=0;i<n;i++)
        dist[i][i]=0;

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==1000000 || dist[k][j]==1000000)
                    continue;

                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int cntAdj_city=n;
        int city=-1;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int c=0;c<n;c++){
            int cnt=0;
            for(int nei=0;nei<n;nei++){
                if(dist[c][nei]<=distanceThreshold)
                cnt++;
            }
            if(cnt<=cntAdj_city){
                cntAdj_city=cnt;
                city=c;
            }
        }
    return city;
    }
}
