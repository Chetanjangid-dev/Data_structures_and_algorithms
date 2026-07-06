class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int low=bloomDay[0];
        int high=low;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]>high){
                high=bloomDay[i];
            }
            if(bloomDay[i]<low){
                low=bloomDay[i];
            }
        }
        
        while(low<high){
            int mid = low + (high - low) / 2;
            int set=0;
            int flowers=0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid){
                    set++;
                }
                else{
                    flowers+=(set/k);
                    set=0;
                }
            }
            flowers+=(set/k);
            if(flowers>=m){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}