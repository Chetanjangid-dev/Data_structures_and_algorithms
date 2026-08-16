import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
    HashSet<Integer> visited;
    int[] nums;
    public boolean explore(int start ,boolean allpos){
       HashMap <Integer,Integer> curr= new HashMap<>();
       int len=0;
       int i = start;
       while(!curr.containsKey(i)){
         if((allpos && nums[i]<0) || (!allpos && nums[i]>0)){
            return false;
         }
          visited.add(i);
          curr.put(i,len);
          i =( ((nums[i]+i)%nums.length )+nums.length )%nums.length;
          len++;
       }
       int cyclelen=curr.size()-curr.get(i);
       return cyclelen>1;

    }
    public boolean circularArrayLoop(int[] nums) {
        this.visited= new HashSet<>();
        this.nums=nums;
        for(int i = 0 ; i<nums.length ; i++)
        {
            if(!visited.contains(i)){
                if(explore(i,nums[i]>0)){
                    return true;
                }                  
            }
        }
        return false;
    }
}