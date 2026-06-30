class Solution {
    public int removeDuplicates(int[] nums) {
        int read=0;
        int write=read;
        while(read<nums.length){
            if(nums[read]==nums[write]){
                read++;
            }
            else if(write+2<=read){
                int temp=nums[write+2];
                nums[write+2]=nums[read];
                nums[read]=temp;
                read++;
                write++;
            }
            else{
                read++;
            }
        }
        return write+2;
    }
}