你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。

我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。

如果我们的地图上只有陆地或者海洋，请返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxDistance(int[][] grid) {
        int row=grid.length;
        if(row==0) return -1;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(queue.isEmpty()){
            return -1;
        }
        int[] x={1,-1,0,0};
        int[] y={0,0,1,-1};
        boolean hasOcean=false;
        int r=0;
        int c=0;
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            r=arr[0];
            c=arr[1];
            for(int i=0;i<4;i++){
                int newx=arr[0]+x[i];
                int newy=arr[1]+y[i];
                if(newx>=0&&newy>=0&&newx<row&&newy<col&&grid[newx][newy]==0){
                    grid[newx][newy]=grid[r][c]+1;
                    hasOcean=true;
                    queue.offer(new int[]{newx,newy});
                }
            }
        }
        return hasOcean?grid[r][c]-1:-1;
    }
}

给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}

