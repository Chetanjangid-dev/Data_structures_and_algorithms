class Solution {
    public int count(int k ,int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int first=0;
        int second=0;
        int count=0;
        
        while(second<nums.length){
           if(map.containsKey(nums[second])){
             map.put(nums[second],map.get(nums[second])+1);
           }
           else{
             map.put(nums[second],1);
           }
           while(map.size() >k && first<=second){
            map.put(nums[first],map.get(nums[first])-1);
            if( map.get(nums[first])==0 ){
              map.remove(nums[first]);
            }
            first+=1;
           }
           count += second-first+1; 
            second+=1;
        }
       return count;
    } 
     public int subarraysWithKDistinct(int[] nums, int k) {
      return count(k,nums)-count(k-1,nums);        
    }
}