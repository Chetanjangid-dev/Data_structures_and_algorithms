
class Solution {
    int[][] matrix;
    public void makerowcolzero(int row,int col){
         //ifor row make all cols 0
        for(int i = 0 ;i<matrix[0].length;i++){
            matrix[row][i]=0;
         }

          for(int j = 0 ;j<matrix.length;j++){
            matrix[j][col]=0;
         }
    }
    public void setZeroes(int[][] matrix) {
      HashSet<String> set = new HashSet<>(); 
      this.matrix=matrix;
      for(int row =0; row<matrix.length; row++ ){
        for(int col=0;col<matrix[0].length;col++){
            if(matrix[row][col]==0){
                String key = row+"#"+col; 
                set.add(key);
            }
        }
      }
      for(String key : set){
          String[] parts = key.split("#");
          int row = Integer.parseInt(parts[0]);
          int col = Integer.parseInt(parts[1]);
          makerowcolzero(row,col);
      }    
    }
}