class Solution {
    int[] nums;
    void reverse(int p1, int p2) {
    while (p1 < p2) {
        if(nums[p1]<0){
             p1++;
             continue;
        }
        if(nums[p2]<0){
             p2--;
             continue;
        }
        int vari = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = vari;

        p1++;
        p2--;
    }
}
    public int[] rotateElements(int[] nums, int k) {   
       this.nums=nums;
       //int n = nums.length;
       int n = 0;
       for(int  i = 0 ;i<nums.length;i++){if(nums[i]>=0) n++;}                       
       if(n==0) return nums;
       k = k % n;
       if(k==0) return nums;
       int i = 0;
       int catched = 0;
       while(catched < k){
        if(nums[i]>=0)  catched++;
        i++;
       }
       reverse(0,i-1);
       reverse(i,nums.length-1);
       reverse(0,nums.length-1);
      return nums;
    }
}