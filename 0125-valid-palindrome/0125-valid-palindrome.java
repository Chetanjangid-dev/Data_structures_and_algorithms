class Solution {
    //   Character.isLetterOrDigit(ch)
    //    Character.toLowerCase(ch);
    public boolean isPalindrome(String s) {
        int first=0;
        int second= s.length()-1;
        while(first<second){
         if (!Character.isLetterOrDigit(s.charAt(first))) {
          first++;
           continue;  
         }
   
         if (!Character.isLetterOrDigit(s.charAt(second))) {
          second--;
          continue;   
         }
         if(     Character.toLowerCase(s.charAt(first) ) !=    Character.toLowerCase(s.charAt(second) )  ){
                 return false;
          }
         first+=1;
         second-=1;
        }
       return true;

    }
}  