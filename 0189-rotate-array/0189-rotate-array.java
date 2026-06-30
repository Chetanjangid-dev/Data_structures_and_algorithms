class Solution {
    public void reverse(int p1,int p2,int[] nums){
       while(p1<p2){
        int temp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
        p1+=1;
        p2-=1;
       }
      return ;
    } 
    public void rotate(int[] nums, int k) {
     // meaning ful rotation
     int n=nums.length;
      k = (k % n);
     // brute force =o(k*n) if k>>>n;
     // optimal n  
     //reverse n-k
    reverse(0,n-k-1,nums);
    reverse(n-k,n-1,nums);
    reverse(0,n-1,nums);
    return ;
    }
}