class Solution {
    public int trap(int[] height) {
      int[] leftmax = new int[height.length];
      int[]  rightmax = new int[height.length];
      int max = 0;
      for(int  i  = 0;i<height.length;i++){
        if(height[i]>max){
            max = height[i];
        }
        leftmax[i] = max;
      }
      max =0;
      for(int  i  = height.length-1;i>=0;i--){
        if(height[i]>max){
            max = height[i];
        }
        rightmax[i] = max;
      }
      int total = 0;
      for(int  i = 0 ;i<height.length;i++){
        if(leftmax[i]>height[i] && rightmax[i]>height[i]){
            total += Math.min(leftmax[i],rightmax[i]) - height[i];
        }
      }
      return total;
        
    }
}