class Solution {
    public String reverseVowels(String s) {
       StringBuilder sb = new StringBuilder(s);
       HashSet<Character> vowels =  new HashSet<>();
       vowels.add('a');
       vowels.add('e');
       vowels.add('i');
       vowels.add('o');
       vowels.add('u');
       vowels.add('A');
       vowels.add('E');
       vowels.add('I');
       vowels.add('O');
       vowels.add('U');
       int first =0;
       int second = s.length()-1;
       while(first<second){
        while(!vowels.contains(sb.charAt(first)) && first<second)
         {
            first++;
         }
        while(!vowels.contains(sb.charAt(second)) && first<second)
         {
            second--;
         }
         char a  =  sb.charAt(first);
         char b =  sb.charAt(second);
         sb.setCharAt(first,b);
         sb.setCharAt(second,a);
         first++;
         second--;
       }   
       return sb.toString();
    }
}