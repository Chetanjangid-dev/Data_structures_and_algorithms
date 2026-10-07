class Solution {
    public String convert(String s, int numRows) {
     if(numRows<=1) return s;
     int cycle = (numRows-1)*2;
     StringBuilder sb =  new StringBuilder();
     for(int i  = 0 ;i<numRows;i++){
        int j=i;
        while(j<s.length()){
            sb.append(s.charAt(j)+"");
            if((i>0  && i <numRows-1) && (j + cycle - 2 * i)<s.length()){
            sb.append(s.charAt(j + cycle - 2 * i)+"");
            }
            j+=cycle;
        }
     }   
     return sb.toString();
    }
}