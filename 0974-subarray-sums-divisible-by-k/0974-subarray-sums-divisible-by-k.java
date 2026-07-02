class Solution {
    public int subarraysDivByK(int[] nums, int k) {
    // for java this is reuired to write  ((prefsum % k) + k) % k
    // bcs if a%k==b&k then a-b/%k will be 0
      HashMap<Integer,Integer> map = new HashMap<>(); 
      int prefsum=0;
      map.put( ((prefsum % k) + k) % k,1);
      int count=0;
      for(int i=0;i<nums.length;i++){
        prefsum+=nums[i];
        if(map.containsKey( ((prefsum % k) + k) % k)){
          count+=map.get( ((prefsum % k) + k) % k);
          map.put( ((prefsum % k) + k) % k,map.get( ((prefsum % k) + k) % k)+1);
        }
        else{
        map.put( ((prefsum % k) + k) % k,1);
        }
      }
      return count;
    }
}