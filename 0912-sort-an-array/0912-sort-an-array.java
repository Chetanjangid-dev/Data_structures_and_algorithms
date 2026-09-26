class Solution {
    int[] nums;
    void mergesort(int low ,int high){
        if(low>=high) return ;
        int mid = (low+high)/2;
        mergesort(low,mid);
        mergesort(mid+1,high);
        merge2sortedarr(low,mid,mid+1,high);
    }
    void merge2sortedarr(int low1,int high1,int low2,int high2){
        int[] temp =  new int[high2-low1+1];
        int prev = 0;
        int p1 = low1;
        int p2 = low2;
        while(p1<=high1 && p2<=high2){
            if(nums[p1]<nums[p2]){
                temp[prev] =nums[p1];
                p1++;
            }
            else{
                temp[prev] = nums[p2];
                p2++; 
            }
            prev++;
        }
        for(int i  =p1;i<=high1;i++){
          temp[prev] = nums[i];
          prev++;
        }
        for(int i  =p2;i<=high2;i++){
          temp[prev] = nums[i];
          prev++;
        }  
        //copy whole sorted temp
        for(int  i = 0;i<temp.length;i++){
            nums[i+low1] = temp[i];
        }
        return ;
    }
    public int[] sortArray(int[] nums) {    
        //o(nlogn) and o(n)
        this.nums=nums;
        mergesort(0,nums.length-1);         
        return nums;
    }
}