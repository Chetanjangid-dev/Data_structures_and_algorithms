class Solution {
    public int compress(char[] chars) {
        int search=0;
        int write=search;
        int startfrom=0;
        while(search<chars.length){
            while(search<chars.length && (chars[write]==chars[search]) ) {
               search++;
            }
            String s;
            if((search-write)==1){
               s=chars[write]+"";  
            }
            else{
               s=chars[write]+""+(search-write);
            }
            for (int i=0;i<s.length();i++){
                chars[i+startfrom]=s.charAt(i);
            }
            startfrom+=s.length();
            write=search;
        }
        return startfrom;
    }
}