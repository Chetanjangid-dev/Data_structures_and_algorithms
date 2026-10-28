class Solution {
    public int trap(int[] height) {
        if(height.length <=2) return 0;
        int first = 0;

        int second = height.length-1;
        int leftmax=0,rightmax=0,total=0;
        while(first<=second){
          if(height[first]<=height[second]){
            total+=Math.max(leftmax,height[first]) - height[first];
            leftmax=Math.max(leftmax,height[first]);
            first++;
          }
          else{
             total+=Math.max(rightmax,height[second]) - height[second];
             rightmax=Math.max(rightmax,height[second]); 
             second--;
          }
        }
        return total;
    }
}