class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> map =  new HashMap<>();
       int sum = 0;
        map.put(sum,-1);
       for(int i = 0 ; i<nums.length;i++)
       {
        sum+=nums[i];
        if(map.containsKey(sum%k)  && i-map.get(sum%k)>=2){
                return true;
        }
        if(!map.containsKey(sum%k))
           map.put(sum%k,i);
       }
       return false;
    }
}