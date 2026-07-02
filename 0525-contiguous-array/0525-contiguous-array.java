class Solution {
    public int findMaxLength(int[] nums) {
      //  i will store the diff of 0 and 1 at every index in hashmap initially i will storr the 0 beeascuse no diff currently this is like if in future i find same  diff in my current index as my prev that mena that index till is  the part which dauses the diff so remove that part and yeah your current balanced subaary is here 
     HashMap<Integer,Integer> map = new HashMap<>();
     map.put(0,-1);
     int zeroes=0;
     int ones=0;
     int diff=0;
     int max=0;
     for (int i=0;i<nums.length;i++){
        if(nums[i]==0){
            zeroes+=1;
        }
        else{
            ones+=1;
        }
        diff=ones-zeroes;
        if(map.containsKey(diff)){
         max=Math.max(max,i-map.get(diff));
        }
        else{
            map.put(diff,i);
        }
     }
    return max;
    }
}