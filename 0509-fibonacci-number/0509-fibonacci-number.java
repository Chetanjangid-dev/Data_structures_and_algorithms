class Solution {
    HashMap<Integer,Integer> dp =new HashMap<>();
    public int fibonacci(int n ){
      // base condtion
      if(n==0 || n==1){return n;}
      if(dp.containsKey(n)){
         return dp.get(n);
      }
      int ans= fibonacci(n-1)+fibonacci(n-2);
      dp.put(n,ans);
      return ans;
    }
    public int fib(int n) {
       return  fibonacci(n);
    }
}