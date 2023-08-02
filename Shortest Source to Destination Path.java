
class Node {
    int i, j;
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int graphBFS(int tx, int ty, int arr[][], int n, int m){
        Deque<Node> dq = new ArrayDeque<Node>();
        dq.add(new Node(0, 0));
        boolean seen[][] = new boolean[n][m];


        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                seen[i][j] = arr[i][j] == 0;
            }
        }
        seen[0][0] = true;


        int lvl = 1;
        int dir[][] ={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!dq.isEmpty()){
            int size = dq.size();
            
            while(size-->0){
                Node curr = dq.poll();
                int x = curr.i, y = curr.j;
                for(int d[]: dir){
                    if(x+d[0]<0 || x+d[0]>=n || y+d[1]<0 || y+d[1]>=m) continue;
                    if(seen[x+d[0]][y+d[1]]) continue;
                    seen[x+d[0]][y+d[1]] = true;
                    if(x+d[0] == tx && y+d[1] == ty) return lvl; // Element found
                    dq.add(new Node(x+d[0], y+d[1]));
                }
            }
            ++lvl;
        }
        

        // Element not found !
        return -1; 
    }
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(X==0 && Y==0) return 0;
        return graphBFS(X, Y, A, N, M);
    }
}
