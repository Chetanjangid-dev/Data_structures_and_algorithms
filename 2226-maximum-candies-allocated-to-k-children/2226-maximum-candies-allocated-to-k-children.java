class Solution {
    public int maximumCandies(int[] candies, long k) {
     //max problem infinity loop ka baap low+high+1/2
     int low=1;
     int high=candies[0];
     long total=0;
     for(int i=0;i<candies.length;i++){
        if(high<candies[i]){
            high=candies[i];
        }
        total+=candies[i];
     }
     if(total<k){
        return 0;
     }
     while(low<high){
        int mid = low + (high - low + 1) / 2;
         long  allocated=0;
        for(int i=0;i<candies.length;i++){
            allocated+=candies[i]/mid;
        }
        if(allocated>=k){
            low=mid;
        }
        else{
            high=mid-1;
        }
     }       
     return low;
    }
}