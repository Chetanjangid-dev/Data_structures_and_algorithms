class Solution {
    public int[][] generateMatrix(int n) {
     int[][] ans= new int[n][n];
     int top,down,left,right;
     top=0;
     down=n-1;
     left=0;
     right=n-1;
     int val=1;
     while(top<=down && left<=right){
        for(int i=left ;i<=right;i++){
         ans[top][i]=val;
         val=val+1;
        }
        top++;
        for(int i=top ;i<=down;i++){
            ans[i][right]=val;
            val++;
        }
        right--;
        //dut to edge case of single row and single column
        // to unhe top and right ohle hi trverse kr lenege and hume waps se bottomand left se trverse krne se phle chekc krna hoga ki kya bottom amd=nd left bche bhi h y anhi 
        if(top<=down){
        for(int i=right ;i>=left;i--){
         ans[down][i]=val;
         val++;
        }
        down--;
        }
        if(left<=right){
        for(int i=down ;i>=top;i--){
         ans[i][left]=val;
         val++;
        }  
        left++;
        }
      }
      return ans;   
    }
}