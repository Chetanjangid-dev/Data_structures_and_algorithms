class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int first=m-1;
         int second=n-1;
         int seperate=m+n-1;
          while( first>=0 && second>=0 ){
            if(nums2[second]>=nums1[first]){
                nums1[seperate]=nums2[second];
                second--;
            }
            else{
                nums1[seperate]=nums1[first];
                first--;
            }
            seperate--;
          }
          for(int i=0;i<=second;i++){
             nums1[i]=nums2[i];
          }
    }
}