class Solution {
    public int hIndex(int[] citations) {
      int low=0;
      int high=citations.length-1;
      while(low<high){
        int mid=low+(high-low)/2;
        int papers=citations.length-mid;
        if(citations[mid]>=papers){
          high=mid;
        }
        else{
          low=mid+1;
        }
      }
      int papers=citations.length-low;
      if(citations[low]<papers){
         return citations[low];
      }
      return papers;
    }
}