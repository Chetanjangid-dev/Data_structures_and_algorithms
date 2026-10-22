class Solution {
    int ind1;
    int ind2;
    int min;
    String s;
    int[] validindices(int first,int second){
        int  i = first;
        int j = ind1;
        while(i<=second){
            if(s.charAt(i) > s.charAt(j)){
                return new int[]{ind1,ind2};
            }
            else if(s.charAt(i) < s.charAt(j)){
                return new int[]{first,second};
            }
            i++;
            j++;
        }
        return new int[]{ind1,ind2};
    } 
    public String shortestBeautifulSubstring(String s, int k) {
     this.s=s;
     if(k> s.length()) return "";
     this.ind1=0;
     this.ind2=Integer.MAX_VALUE-1;
     int ones = 0;
     int first=0;
     int second=0;
     while(second<s.length()){
        char curr = s.charAt(second);
        if(curr=='1') ones++;
        while(first<=second  && ones==k){
          if(second-first+1 == ind2-ind1+1){
             int[] ans = validindices(first,second);
             ind1 = ans[0];
             ind2 =ans[1];
          }
          else if(second-first+1<ind2-ind1+1){
             ind1 = first;
             ind2 = second;
          }
          if(s.charAt(first) == '1')  ones--;
          first++;
        }
        second++;
     }
     if(ind2 == (Integer.MAX_VALUE-1))  return "";
     return s.substring(ind1,ind2+1);
     }
}