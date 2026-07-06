class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    int low_outer=0;
    int high_outer=matrix.length-1;
    while(low_outer<=high_outer){
        int mid_outer=low_outer+(high_outer-low_outer)/2;
        int n=matrix[mid_outer].length-1;
        if(matrix[mid_outer][n] < target ){
            low_outer=mid_outer+1;
        }
        else if (matrix[mid_outer][0] <= target && target<=matrix[mid_outer][n]){
            int low_inner=0;
            int high_inner=n;
            while(low_inner<=high_inner){
                int mid_inner=low_inner+(high_inner-low_inner)/2;
                if(matrix[mid_outer][mid_inner]==target){
                    return true;
                }
                else if(matrix[mid_outer][mid_inner]>target){
                    high_inner=mid_inner-1;
                }
                else{
                    low_inner=mid_inner+1;
                }
            }
            return false;
        }
        else{
            high_outer=mid_outer-1;
        }
    }

    return false;
    }
}