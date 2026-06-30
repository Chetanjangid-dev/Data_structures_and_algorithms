import java.util.Arrays;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      ArrayList<Integer> ans=  new ArrayList<>();
      int first=0;
      int second=first;     
      while(first<nums1.length && second<nums2.length){
        if(nums1[first]==nums2[second]){
        ans.add(nums1[first]);
        first+=1;
        second+=1;
        while( first>0 && first<nums1.length && nums1[first]==nums1[first-1]){
           first+=1;
        }
        while( second>0 && second <nums2.length && nums2[second]==nums2[second-1]){
           second+=1;
        }
        }
        else if (nums1[first]<nums2[second]){
            first+=1;
         while( first >0 && first<nums1.length && nums1[first]==nums1[first-1]){
           first+=1;
        }
        }
        else{
            second+=1;
            while( second>0 && second <nums2.length && nums2[second]==nums2[second-1]){
           second+=1;
        }
        }
      }
     
    // System.out.println(ans);
     int[] Ans=new int[ans.size()];
     for(int i=0;i<ans.size();i++){
        Ans[i]=ans.get(i);
     }
     return Ans ;

    }
}