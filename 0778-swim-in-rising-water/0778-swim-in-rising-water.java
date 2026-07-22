class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[][] path=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
         Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        int row,col,max_elevation;
        int[] pair;
        row=0;
        col=0;
        max_elevation=grid[row][col];
        q.offer(new int[]{row,col,max_elevation});
        path[row][col]=max_elevation;
        while(!q.isEmpty()){
           pair=q.poll();
           row=pair[0];
           col=pair[1];
           max_elevation=pair[2];
           if(max_elevation>path[row][col]){continue;}
                // up
              // up
            if(row - 1 >= 0 && Math.max(grid[row-1][col], max_elevation) < path[row-1][col]) {
                path[row-1][col] = Math.max(grid[row-1][col], max_elevation);
                q.offer(new int[]{row-1, col, path[row-1][col]});
            }
            // down
            if(row + 1 < grid.length && Math.max(grid[row+1][col], max_elevation) < path[row+1][col]) {
                path[row+1][col] = Math.max(grid[row+1][col], max_elevation);
                q.offer(new int[]{row+1, col, path[row+1][col]});
            }
            // left
            if(col - 1 >= 0 && Math.max(grid[row][col-1], max_elevation) < path[row][col-1]) {
                path[row][col-1] = Math.max(grid[row][col-1], max_elevation);
                q.offer(new int[]{row, col-1, path[row][col-1]});
            }
            // right
            if(col + 1 < grid[0].length && Math.max(grid[row][col+1], max_elevation) < path[row][col+1]) {
                path[row][col+1] = Math.max(grid[row][col+1], max_elevation);
                q.offer(new int[]{row, col+1, path[row][col+1]});
            }
                    }
        return path[grid.length-1][path[0].length-1];
    }
}