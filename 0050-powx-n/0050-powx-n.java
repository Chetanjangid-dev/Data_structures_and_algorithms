class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
      
        double ans=1.0;
        boolean isneg  = n < 0;
        //n=bcz n can be anythong like if its neg infinty and we do math.asb(n) then theppso value wll not fit in posintive integer and it reims beg inifnti so we need to sotre the ppower n as a long to make that accesbile 
         long pow = Math.abs((long)n);
        while(pow>1.0){
          if(pow%2!=0){ ans *= x;}
           pow /=2;
           x = (x*x);
        }
        ans*=x;
        return isneg?(1/ans) : ans;
    }
}