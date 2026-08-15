class Solution {
    public int compress(char[] chars) {
     int first=0;
     int second=first;
     int lastpos=first;
     while(second<chars.length){
        while(second < chars.length && chars[second]==chars[first] ){
            second++;
        }
        //here second!=first
        chars[lastpos]=chars[first];
        lastpos++;
        int freq = second-first;
        if(freq>1){
           int divisor = 1;
           while (freq / divisor >= 10) {
               divisor *= 10;
           }
           while (divisor > 0) {
               int digit = freq/ divisor;
               chars[lastpos]=(char)(digit + '0');
               lastpos++;
               freq =freq % divisor;
               divisor /= 10;
            } 
        }
        first=second;        
      }
      return lastpos;
      //actually thte lastpos-1 is last vldi index but lastps showing the lentght pf valid area

    }
}