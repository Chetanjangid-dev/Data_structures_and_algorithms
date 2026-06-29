import java.util.HashMap;
import java.util.Arrays;
class Solution {
     public int[] twoSum(int[] nums, int target) {
      int[] res={-1,-1};
      //hashmpa= time =n memory =n overall nhi szie hoga worst case me bhi  
      HashMap<Integer,Integer> map = new HashMap<>();      
      // requireemnt,index// requi5ement=target-currentavlue
      for(int i=0;i<nums.length;i++){
        // kya merko currentvalue ki requireemnt h
        if(map.containsKey(nums[i])){
             res[0]=i;
             res[1]=map.get(nums[i]);
            return res;
        }
        int requirement=target-nums[i];
        map.put(requirement,i);        
      }
      return res;
 }   
}