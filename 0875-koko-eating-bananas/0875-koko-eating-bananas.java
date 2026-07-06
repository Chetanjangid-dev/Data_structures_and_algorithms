class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int low=1;
     int high=piles[0];
     for(int i=0;i<piles.length;i++){
        if(piles[i]>high){
            high=piles[i];
        }
     }
     while(low<high){
    int mid=(low+high)/2;
    int takenhours=0;
    //check n 
     for(int i=0;i<piles.length;i++){
        int additional;
        if(piles[i]%mid==0){
            additional=0;
        }
        else{
            additional=1;
        }
        takenhours+=(piles[i]/mid)+additional;
     }
     if(takenhours<=h){
        high=mid;
     }
     else{
        low=mid+1;
     }
     }
      return low;  
    }
}