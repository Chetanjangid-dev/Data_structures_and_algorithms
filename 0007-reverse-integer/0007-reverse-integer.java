class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int digit = (x % 10);
            x = x/10;
            //hum overflow  ans*10 pr hi chek kr rhe   nnad even ye overflow ho gya to compre rkna muski hoga so hum insted of doing  intmaxval<ans*10 we doing maxval/10<ans  whoch keeps cpmpirson inrnage 
            if(  ans>Integer.MAX_VALUE/10  ||  ans<Integer.MIN_VALUE/10){
                return 0;
            }

            ans=(ans*10)+digit;
        }
        return ans;
    }
}