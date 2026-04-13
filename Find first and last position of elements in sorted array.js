var searchRange = function(nums, target) {
  let low=0
  let high = nums.length - 1
  let varablethatkeepfirstvalidindex=-1
  while (high>=low)
{
  mid=low+Math.floor((high-low)/2)
  //for first occurence
  if (nums[mid]==target){
    varablethatkeepfirstvalidindex=mid
   high=mid-1// reduce right region
  }
  else if (nums[mid]>target){
    high=mid-1
  }
  else{
    low=mid+1
  }
}
 low=0
  high = nums.length - 1
  let varablethatkeeplastvalidindex=-1
  while (high>=low)
{
  let mid=low+Math.floor((high-low)/2)
  //for last occurence
  if (nums[mid]==target){
   varablethatkeeplastvalidindex=mid
   low=mid+1// reduce left region
  }
  else if (nums[mid]>target){
    high=mid-1
  }
  else{
    low=mid+1
  }
}
return [varablethatkeepfirstvalidindex,varablethatkeeplastvalidindex]
 
};
