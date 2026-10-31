class Solution {
 
    public int longestWPI(int[] hours) {
     int max= 0 ;
     for(int i = 0 ;i<hours.length;i++){
        int tired_days = 0;
        int non_tired_days = 0;
        for(int  j = i;j<hours.length;j++){
          if(hours[j]>8){
            tired_days++;
          }
          else{
            non_tired_days++;
          }
          if(tired_days>non_tired_days){
            max = Math.max(j-i+1,max);
          }
        }
     }
     return max; 
    }
}