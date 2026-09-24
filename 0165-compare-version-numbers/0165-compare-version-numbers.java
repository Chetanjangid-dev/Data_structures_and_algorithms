class Solution {
    String version1,version2;
     public int compareVersion(String version1, String version2){
        int first = 0 ;
        int second = 0;
        while(first<version1.length() || second<version2.length()){
            if(first>=version1.length() && second >= version2.length()){
                return 0;
            }
            int temp1 = first;
            int temp2 = second;
            while(first<version1.length()  && version1.charAt(first)!='.' ){
                first++;
            }
            while(second<version2.length()  && version2.charAt(second)!='.' ){
                second++;
            }
            int n1,n2;
            if(temp1<version1.length()){
                n1 =   Integer.parseInt(version1.substring(temp1,first));
            }
            else{
                n1=0;
            }
            if(temp2<version2.length()){
                n2 =   Integer.parseInt(version2.substring(temp2,second));
            }
            else{
                n2=0;
            }
            if( n1< n2){
                return -1;
            }
            else if(n1 > n2){
                return 1;
            }
            first++;
            second++;
        }
        return 0;
    }
}