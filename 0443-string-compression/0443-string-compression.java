class Solution {
    public int compress(char[] chars) {
        int search=0;
        int write=search;
        int startfrom=0;
        while(search<chars.length){
            while(search<chars.length && (chars[write]==chars[search]) ) {
               search++;
            }
            chars[startfrom]=chars[write];
            int n=search-write;
            startfrom++;
            if(n>1){
             while(n!=0){
                int divisor = 1;
                while (n / divisor >= 10) {
                    divisor *= 10;
                }
                while (divisor > 0) {
                    int digit = n / divisor;
                    chars[startfrom]=(char)('0'+digit);
                    startfrom++;
                    n %= divisor;
                    divisor /= 10;
                }
                
             }
            }
            write=search;
        }
        return startfrom;
    }
}