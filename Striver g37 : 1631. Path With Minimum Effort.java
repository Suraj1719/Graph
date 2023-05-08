//Article : https://takeuforward.org/data-structure/g-37-path-with-minimum-effort/

code :

Time complexity: O(ElogV) = O(n*m*4)(n*m)
  space com : O(n*m)

class Solution {
    class Tuples{
        int distance,row,col;
        Tuples(int distance,int row,int col){
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        
        int dist[][]=new int[n][m];
        PriorityQueue<Tuples>pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new Tuples(0,0,0));
        int c_r[]={-1,0,1,0};
        int c_c[]={0,-1,0,1};
        
        while(!pq.isEmpty()){
            Tuples cur=pq.peek();
            pq.remove();
            int diff=cur.distance;
            int r=cur.row;
            int c=cur.col;
            
            if(r==n-1 && c==m-1) return diff;//as min heap when
            //it comes destination that is the minimum effort among all path
            
            for(int i=0;i<4;i++){
                int new_r=r+c_r[i];
                int new_c=c+c_c[i];
                
                if(new_r>=0 && new_r<n && new_c>=0 && new_c<m){
                    int newEffort=Math.max(diff,Math.abs(heights[r][c]-
                    heights[new_r][new_c]));
                    
                    if(newEffort<dist[new_r][new_c]){
                        dist[new_r][new_c]=newEffort;
                        pq.add(new Tuples(newEffort,new_r,new_c));
                    }
                }
            }
        }
    return 0;
    }
}
