class Solution {
    public int strStr(String haystack, String needle) {
        int[] lcps =  new int[needle.length()];
        int len = 0;
        for (int i = 1; i < needle.length(); i++) {

            while (len > 0 && needle.charAt(i) != needle.charAt(len)) {
                len = lcps[len - 1];
            }

            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
            }
            lcps[i] = len;
        }
        int i = 0;
        int j = 0;
        while(i<haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            }
            else if (j > 0) {
                j = lcps[j - 1];
            }
            else {
                i++;
            }
        }
        return -1;
    }
}