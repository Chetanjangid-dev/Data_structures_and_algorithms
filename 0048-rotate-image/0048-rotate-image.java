class Solution {
    int[][] matrix ;
    public void reverse(int start , int end , int col)
    { 
      while(start<end){
        int temp = matrix[start][col];
        matrix[start][col]=matrix[end][col];
        matrix[end][col]=temp;
        start++;
        end--; 
      }
    }
    public void rotate(int[][] matrix) {
        this.matrix=matrix;
        //reverse all cols 
        for(int col=0 ; col < matrix[0].length ; col++ ){
            reverse(0,matrix.length-1,col);
        } 
        //replacemnt-  row wise
        for(int row = 0; row<matrix.length ;row++){
            for( int col = 0 ; col < matrix[row].length ; col++ ){
                if(col  > row){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row]=temp;
                }
            }
        }
    }
}