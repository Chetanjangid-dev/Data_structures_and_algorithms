class Solution {
    public int removeDuplicates(int[] nums) {
    int read=0;
    int write=read;
    while(read<nums.length){
        if(nums[read]==nums[write]){
            read++;
        }
        else{
            int temp=nums[write+1];
            nums[write+1]=nums[read];
            nums[read]=temp;
            read++;
            write++;
        }
    }
    return write+1;
    }
}