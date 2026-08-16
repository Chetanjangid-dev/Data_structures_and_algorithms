class Solution {
    public int maxArea(int[] height) {
    int first=0;
    int last=height.length-1;
    int max=0;
    int capacity;
    int prev;
    while(first<last){ 
     if(height[first]<height[last]){
         capacity=height[first]*(last-first);
         max=Math.max(max,capacity);
         prev=height[first];
         first+=1;
         while(last>first && prev >= height[first]){
            first++;
         }
      }
      else{
         capacity=height[last]*(last-first);
         max=Math.max(max,capacity);
         prev=height[last];
         last-=1;
         while(last>first && prev >= height[last]){
            last-=1;
         }
      }
    }
    return max;
            
    }
}