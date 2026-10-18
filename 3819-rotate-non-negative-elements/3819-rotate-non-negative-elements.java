class Solution {
void reverse(int p1, int p2, List<Integer> temp) {
    while (p1 < p2) {
        int vari = temp.get(p1);
        temp.set(p1, temp.get(p2));
        temp.set(p2, vari);

        p1++;
        p2--;
    }
}
    public int[] rotateElements(int[] nums, int k) {
       List<Integer> temp =  new ArrayList<>();
       for(int i =0;i<nums.length;i++){
         if(nums[i]>=0){
            temp.add(nums[i]);
         }
       }   
       int n = temp.size();
       if(n==0) return nums;
       k = k % n;
       reverse(0,k-1,temp);
       reverse(k,n-1,temp);
       reverse(0,n-1,temp);
       int prev = 0;
       for(int i = 0 ;i<nums.length;i++){
         if(nums[i]>=0){
            nums[i] = temp.get(prev);
            prev++; 
         }
       }
      return nums;
    }
}