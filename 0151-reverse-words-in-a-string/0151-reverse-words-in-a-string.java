class Solution {
    public String reverseWords(String s) {
     StringBuilder sb  =   new StringBuilder();
     int temp = s.length()-1;
     int p = s.length()-1;
     while(p>=0){
       while(p>=0 && s.charAt(p)==' '){
         p--;
       }
       //ab p ek char pr hoga so temp ko yha merker ki trh user kro
       temp = p;
       //next emepty space na ane tk p ko move kro
       while(p>=0 && s.charAt(p)!=' '){
         p--;
       }
       //ya to ab p ek empty space pr hoga ya string k strtindex ko apr llr cchuka hoga -1
       //in both cases malle a subtsring of size p+1 to temp+1 and psuh in answer
        if(sb.length()>0 && p+1<=temp){
             sb.append(" ");
        }
        sb.append(s.substring(p+1,temp+1));
     }
     return sb.toString();
    }
}