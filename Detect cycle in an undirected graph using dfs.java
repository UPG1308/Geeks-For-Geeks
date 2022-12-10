class Solution{
    private boolean dfs(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int adjacentNode :adj.get(node)){
            if(!vis[adjacentNode]){
                if(dfs(adjacentNode, node, vis, adj)) return true;
            }
            else if(adjacentNode != parent) return true;
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
}
