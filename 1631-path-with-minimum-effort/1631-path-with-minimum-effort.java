class Solution {
    public int minimumEffortPath(int[][] heights) {
         PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
         int[][] efforts = new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
         Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
         int row,col,effort;
         row=0;
         col=0;
         effort=0;
         q.offer(new int[]{row,col,effort});
         efforts[0][0]=0;
         //now the effort is max effort to rrch at this cell we are minimg it now 
         while(!q.isEmpty()){
            int[] pair = q.poll();
            row=pair[0];
            col=pair[1];
            effort = pair[2];
            if(row == heights.length-1 &&
               col == heights[0].length-1)
               return effort;
            if(effort>efforts[row][col]){continue;}                
                 // up
                if(row - 1 >= 0 && Math.max(Math.abs(heights[row-1][col] - heights[row][col]), effort) < efforts[row-1][col]) {
                    efforts[row-1][col] = Math.max(Math.abs(heights[row-1][col] - heights[row][col]), effort);
                    q.offer(new int[]{row-1, col, efforts[row-1][col]});
                }
                // down
                if(row + 1 < heights.length && Math.max(Math.abs(heights[row+1][col] - heights[row][col]), effort) < efforts[row+1][col]) {
                    efforts[row+1][col] = Math.max(Math.abs(heights[row+1][col] - heights[row][col]), effort);
                    q.offer(new int[]{row+1, col, efforts[row+1][col]});
                }
                // left
                if(col - 1 >= 0 && Math.max(Math.abs(heights[row][col-1] - heights[row][col]), effort) < efforts[row][col-1]) {
                    efforts[row][col-1] = Math.max(Math.abs(heights[row][col-1] - heights[row][col]), effort);
                    q.offer(new int[]{row, col-1, efforts[row][col-1]});
                }
                // right
                if(col + 1 < heights[0].length && Math.max(Math.abs(heights[row][col+1] - heights[row][col]), effort) < efforts[row][col+1]) {
                    efforts[row][col+1] = Math.max(Math.abs(heights[row][col+1] - heights[row][col]), effort);
                    q.offer(new int[]{row, col+1, efforts[row][col+1]});
                }
        }
        return efforts[heights.length-1][heights[0].length-1];
                        
    }
}