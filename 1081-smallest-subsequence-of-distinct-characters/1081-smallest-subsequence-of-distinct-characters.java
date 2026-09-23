class Solution {
    public String smallestSubsequence(String s) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Set<Character> visited = new HashSet<>();

        int i = 0;
while(i < s.length()) {

    char ch = s.charAt(i);

    map.put(ch, map.get(ch) - 1);

    if(map.get(ch) == 0) {
        map.remove(ch);
    }

    if(visited.contains(ch)) {
        i++;
        continue;
    }

    while(!stack.isEmpty()
          && ch < stack.peek()
          && map.containsKey(stack.peek())) {

        visited.remove(stack.pop());
    }

    stack.push(ch);
    visited.add(ch);

    i++;
}
        StringBuilder sb = new StringBuilder();

        for(i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}