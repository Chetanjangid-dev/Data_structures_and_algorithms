class Solution {
    public int maxArea(int[] height) {
    int first=0;
    int last=height.length-1;
    int max=0;
    int capacity;
    while(first<last){ 
     if(height[first]<height[last]){
        capacity=height[first]*(last-first);
        max=Math.max(max,capacity);
        first+=1;
      }
      else{
         capacity=height[last]*(last-first);
         max=Math.max(max,capacity);
         last-=1;
      }
    }
    return max;
            
    }
}