class Solution {
    public void moveZeroes(int[] nums) {
       int read=0;
       int write=read;
       while(read<nums.length){
        if(nums[read]==0){
            read++;
        }
        else{
            //swap
            int temp=nums[read];
            nums[read]=nums[write];
            nums[write]=temp;
            read++;
            write++;
        }

       }





    }
}