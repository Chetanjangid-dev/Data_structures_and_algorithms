import java.util.HashMap;
import java.util.Arrays;
class Solution {
     public int[] twoSum(int[] nums, int target) {
      //hashmpa= time =n memory =n overall nhi szie hoga worst case me bhi  
      HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();      
      for(int i=0;i<nums.length;i++){
       // duplicate handling
       
       if(map.containsKey(nums[i])){
       if(map.get(nums[i]).size()==2){
         continue;
       }
       map.get(nums[i]).add(i);
      }else{
        map.put(nums[i],new ArrayList<>());
        map.get(nums[i]).add(i);
      }
      }
     Arrays.sort(nums);// time =o(nlogn);
     int first=0;
     int second=nums.length-1;
     while(second>first)//o(n) time 
     {
      int res=nums[first]+nums[second];
      if(res==target){
        // to avoid same index
        int index1= map.get(nums[first]).remove(map.get(nums[first]).size()-1);
        int index2=map.get(nums[second]).remove(map.get(nums[second]).size()-1);
        int[] result={index1,index2};
        return result;
      }     
      else if(res>target){
        second-=1;
      }
      else{
        first+=1;
      }
     }
    int[] result={-1,-1};
    return result;
   // time =nlogn space =n
 }   
}