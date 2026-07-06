class Solution {
     public int count_ele(int m, int n,int mid){
        int row=m;
        int col=1;
        int count=0;
        while(row>=1 && col<=n){
          if(row*col<=mid){
            count+=row;
            col++;
          }
          else{
             row--;
          }
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
       //m=rows n=cols k=kth smallest
      int low=1;
      int high=m*n;
      while(low<high){
        int mid=low+(high-low)/2;
        int count=count_ele(m,n,mid);
        if(count>=k){
            high=mid;
        }
        else{
            low=mid+1;
        }
      }
      return low;
    }
}