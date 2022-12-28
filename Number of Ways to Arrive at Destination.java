class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int m = roads.size();
        for(int i = 0;i < m; i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.first - y.first);
        
        int dist[] = new int[n];
        int ways[] = new int[n];
        
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        int mod = (int)(1e9 + 7);
        
        while(pq.size() != 0){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int edN = it.second;
                
                if(dis + edN < dist[adjNode]){
                    dist[adjNode] = dis + edN;
                    pq.add(new Pair(dis + edN, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis + edN == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}
