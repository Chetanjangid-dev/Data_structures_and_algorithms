class Solution {
    StringBuilder sb;
    public String compressedString(String word) {
        this.sb =  new StringBuilder();
        int second = 0;
        int first = 0;
        while(second<word.length()){
            while( second<word.length() && word.charAt(first) == word.charAt(second) && (second -first) < 9 ){
                second++;
            }
            sb.append((second-first)+""+word.charAt(first) );
            first = second;
        }
        return sb.toString();
    }
}