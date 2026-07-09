class Solution {
    public int fibonacci(int n ){
      // base condtion
      if(n==0 || n==1){return n;}
      return fibonacci(n-1)+fibonacci(n-2);
    }
    public int fib(int n) {
       return  fibonacci(n);
    }
}