package advanced;

//岛屿的数量
public class NumberOfIslands {

    //在往 右下左上 遍历 时会用到 dx, dy, dx 对应 i 行, dy 对应 j 列, dx 和 dy 组合后可得四个坐标 (i, j + 1), (i + 1, j), (i , j - 1), (i - 1, j)
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public int numIslands(char[][] grid){
        if(grid == null){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ++res;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        for(int k = 0; k < 4; ++k){
            //  private final int[] dx = {0, 1, 0, -1};
            //  private final int[] dy = {1, 0, -1, 0};
            int x = i + dx[k];
            int y = j + dy[k];
            if(0 <= x && x < n && 0 <= y && y < m && grid[x][y] == '1'){
                grid[x][y] = '0';
                dfs(grid, x, y);
            }
        }
    }
    
    public void test(){
        char[] arr1 = new char[]{'1', '1', '1', '1', '0'};
        char[] arr2 = new char[]{'1', '1', '0', '1', '0'};
        char[] arr3 = new char[]{'1', '1', '0', '0', '0'};
        char[] arr4 = new char[]{'0', '0', '0', '0', '0'};
        char[][] arr = {arr1, arr2, arr3, arr4};
        int res = numIslands(arr);
        System.out.println("result -> " + res); //result -> 1
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.test();
    }
}
