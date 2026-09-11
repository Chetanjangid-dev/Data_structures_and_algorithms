class Solution {
    public String gcdOfStrings(String str1, String str2) {
       if(str2.length()>str1.length()) return gcdOfStrings(str2,str1);
        String temp1 = str1+str2;
        String temp2 = str2+str1;
        if(!temp1.equals(temp2)){
           return "";
        }
        return str1.substring(0,gcd(str1.length() , str2.length()) );   
    }
    int gcd(int a, int b) {
    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}
}