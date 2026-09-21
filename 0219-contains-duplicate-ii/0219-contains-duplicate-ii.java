class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
     HashMap<Integer,Integer> map = new HashMap<>();
     for(int i =0 ;i<nums.length ;i++){
        if(map.containsKey(nums[i])){
            int first = map.get(nums[i]);
            int second = i;
            if(Math.abs(first-second) <=k ){
                return true;
            }
        }
        map.put(nums[i],i);
     }  
     return false;
    }
}