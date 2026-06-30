import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums);
    for(int i=0;i<nums.length-3;i++){
        if(i>0 && nums[i-1]==nums[i]){
            continue;
        }
        for(int j=i+1;j<nums.length-2;j++){
           if(j>i+1 && nums[j-1]==nums[j]){
             continue;
            }
            int first=j+1;
            int second=nums.length-1;
            while(first<second){
                long  total=  (long) nums[i]+nums[j]+nums[first]+nums[second];
                if(total==target){
                    result.add(Arrays.asList(nums[i],nums[j],nums[first],nums[second]));
                     second-=1;
                     first+=1;
                     while(first<second  && nums[first-1]==nums[first]){
                        first+=1;
                     }
                    while(first<second && second<nums.length-1 && nums[second+1]    ==nums[second]){
                        second-=1;
                     }
                }
                else if (total>target)
                {
                    second-=1;
                }
                else{
                    first+=1;
                }
            }
        }
    }
    return result;
    }
}