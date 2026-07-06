class Solution {
    public int count_ele(int[][] matrix,int mid){
        int row=matrix.length-1;
        int col=0;
        int count=0;
        while(row>=0 && col<matrix[0].length){
          if(matrix[row][col]<=mid){
            count+=row+1;
            col++;
          }
          else{
             row--;
          }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
      int low=matrix[0][0];
      int high=matrix[matrix.length-1][matrix[0].length-1];
      while(low<high){
        int mid=low+(high-low)/2;
        int count=count_ele(matrix,mid);
        if(count>=k){
            high=mid;
        }
        else{
            low=mid+1;
        }
      }
      return low;
    }
}