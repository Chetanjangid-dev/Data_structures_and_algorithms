class Solution {

    int[] s2_freq;

    boolean check(int[] s1_freq) {

        for (int i = 0; i < 26; i++) {

            if (s1_freq[i] != s2_freq[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s2, String s1) {

        // s2 should be shorter or equal to s1
        if (s2.length() > s1.length()) return false;

        s2_freq = new int[26];
        int[] s1_freq = new int[26];

        // frequency of s2
        for (int i = 0; i < s2.length(); i++) {

            char ch = s2.charAt(i);
            s2_freq[ch - 'a']++;
        }

        // first window of s1
        for (int i = 0; i < s2.length(); i++) {

            char ch = s1.charAt(i);
            s1_freq[ch - 'a']++;
        }

        if (check(s1_freq)) return true;

        // sliding window
        for (int i = s2.length(); i < s1.length(); i++) {

            // add new character
            char add = s1.charAt(i);
            s1_freq[add - 'a']++;

            // remove old character
            char rem = s1.charAt(i - s2.length());
            s1_freq[rem - 'a']--;

            if (check(s1_freq)) return true;
        }

        return false;
    }
}