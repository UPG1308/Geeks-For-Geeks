class Pair{
    int first , second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class tuple{
    int first, second, third; 
    tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, src, 0));
        int dist[] = new int[n];
        for(int i = 0; i < n; i++) dist[i] = (int)(1e9);
        
        dist[src] = 0;
        
        while(!q.isEmpty()){
            tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second; 
            int cost = it.third;
            
            if(stops > k) continue;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int edN = iter.second;
                
                if(cost + edN < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edN;
                    q.add(new tuple(stops + 1, adjNode, cost + edN));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
