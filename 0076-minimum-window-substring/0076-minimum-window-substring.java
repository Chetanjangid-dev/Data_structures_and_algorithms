import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> t_hash = new HashMap<>();
        HashMap<Character, Integer> s_hash = new HashMap<>();

        // Frequency of characters in t
        for (char ch : t.toCharArray()) {
            t_hash.put(ch, t_hash.getOrDefault(ch, 0) + 1);
        }

        int first = 0;
        int second = 0;
        int approvedTimes = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (second < s.length()) {
            char ch = s.charAt(second);

            // Only process characters that are in t
            if (t_hash.containsKey(ch)) {
                s_hash.put(ch, s_hash.getOrDefault(ch, 0) + 1);

                if (s_hash.get(ch).equals(t_hash.get(ch))) {
                    approvedTimes++;
                }
            }

            while (approvedTimes == t_hash.size()) {
                if (second - first + 1 < minLen) {
                    minLen = second - first + 1;
                    start = first;
                }

                char left = s.charAt(first);

                if (t_hash.containsKey(left)) {
                    s_hash.put(left, s_hash.get(left) - 1);

                    if (s_hash.get(left) < t_hash.get(left)) {
                        approvedTimes--;
                    }

                    if (s_hash.get(left) == 0) {
                        s_hash.remove(left);
                    }
                }

                first++;
            }

            second++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}