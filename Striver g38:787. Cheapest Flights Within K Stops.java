Article : https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/
code : 

Time com:O(flight array size)
  space com:O(n)

class Solution {
    class pair{
        int first,second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    class Tuples{
        int first,second,third;
        Tuples(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //make an adj list
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            //from city : pair(to , price)
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        //here we do not have to use priority Queue as we store according to stops and it store sortedly like min stopes to max order
        Queue<Tuples>q=new LinkedList<>();

        q.add(new Tuples(0,src,0));
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;

        while(!q.isEmpty()){
            Tuples cur=q.peek();
            q.remove();
            int stops=cur.first;
            int city=cur.second;
            int cost=cur.third;

            if(stops>k) continue;

            for(pair nei:adj.get(city)){
                int adjCity=nei.first;
                int price=nei.second;

                if(cost+price<dist[adjCity]){
                    dist[adjCity]=cost+price;
                    q.add(new Tuples(stops+1,adjCity,cost+price));
                }
            }
        }
    if(dist[dst]==(int)(1e9)) return -1;
    return dist[dst];
    }
}
