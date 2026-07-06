class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //lower bounnd se km nhi ho skti or high bound e jyadanhi honi chaihuye
        int low=weights[0];
        int high=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>low){
                low=weights[i];
            }
            high+=weights[i];
        }
        while(low<high){
            int mid=low+(high-low)/2;
            //cehck
            int current_weight=0;
            int takendays=0;
            for(int i=0;i<weights.length;i++){
               if(current_weight+weights[i] <= mid){
                 current_weight+=weights[i];
               }
               else{
                  current_weight=weights[i];
                  takendays+=1;
               }
            }
            takendays+=1;
            if(takendays<=days){
               high=mid;               
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}