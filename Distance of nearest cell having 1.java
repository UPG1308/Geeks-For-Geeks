class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int delRow[] = { -1, 0, +1, 0};
        int delCol[] = { 0, +1, 0, -1};
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0){
                    vis[nRow][nCol] = 1;
                    q.add(new Node(nRow, nCol, steps + 1));
                }
                
            }
        }
        return dist;
    }
}

class Node{
    int first, second, third;
    Node(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
