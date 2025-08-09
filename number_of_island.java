// Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

// Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

// Examples:

// Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
// Output: 4
 
// Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
// Output: 2

// Constraints:
// 1 ≤ n, m ≤ 500
// grid[i][j] = {'L', 'W'}

class number_of_island{
    static boolean[][] visited;
    static int r,c;
    public int countIslands(char[][] grid) {
        // Code here
        r = grid.length;
        c = grid[0].length;
        visited = new boolean[r][c];
        int ans=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!visited[i][j] && grid[i][j]!='W'){
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    static void dfs(int i,int j,char[][] grid){
        if(i<0 || i>=r || j<0 || j>=c) return;
        if(grid[i][j] == 'W' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i+1,j+1,grid);
        dfs(i-1,j-1,grid);
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        dfs(i+1,j-1,grid);
        dfs(i-1,j+1,grid);
    }
    
}
