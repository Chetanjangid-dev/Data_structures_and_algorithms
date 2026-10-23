class Solution {
boolean compare(HashMap<Character, Integer> map,
                HashMap<Character, Integer> curr) {
    for (char ch : map.keySet()) {
        if (map.get(ch) > curr.getOrDefault(ch, 0)) {
            return false;
        }
    }
    return true;
}
    public int balancedString(String s) {
        int val =s.length()/4;
        int q = -val, w = -val, e = -val, r = -val;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'Q') q++;
            else if (ch == 'W') w++;
            else if (ch == 'E') e++;
            else if (ch == 'R') r++;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> curr = new HashMap<>();
        int windowSize = 0;
        if (q > 0) { map.put('Q', q); windowSize += q; }
        if (w > 0) { map.put('W', w); windowSize += w; }
        if (e > 0) { map.put('E', e); windowSize += e; }
        if (r > 0) { map.put('R', r); windowSize += r; }
        int first = 0;
        int second = first;
        int min = Integer.MAX_VALUE;
        if(map.size() == 0) return map.size(); 
        while(second<s.length()){
           curr.put(s.charAt(second), curr.getOrDefault(s.charAt(second), 0) + 1);
           while(first<=second && compare(map,curr)){
              min = Math.min(min,second-first+1);
              curr.put(s.charAt(first),curr.get(s.charAt(first))-1);
             if (curr.get(s.charAt(first)) == 0) { 
              curr.remove(s.charAt(first)); 
             }

              first++;
           }
           second++;
        }
        if(min == Integer.MAX_VALUE) return 0;
       return  min;             
     }
}