class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       //adjacency
       HashMap <String,List<String>> adj= new HashMap<>();
       boolean is_end_in_wl=false;
       for (String word : wordList) {
            if (word.equals(endWord))
                is_end_in_wl = true;
            adj.put(word, new ArrayList<>());
        }
        if (!is_end_in_wl)
            return 0;

        if (!adj.containsKey(beginWord)) {
            wordList.add(beginWord);
            adj.put(beginWord, new ArrayList<>());
        }
      // Collections.sort(wordList);
      for(int i=0;i<wordList.size()-1;i++){
        for(int j=i+1;j<wordList.size();j++){
          String u=wordList.get(i);
          String v= wordList.get(j);
          if(match(u,v)){
            adj.get(u).add(v);
            adj.get(v).add(u);
          } 
        }
       }
            Set<String> visited = new HashSet<>();
            Queue<String> q = new ArrayDeque<>();

            q.offer(beginWord);
            visited.add(beginWord);

            int level = 1;

            while (!q.isEmpty()) {

                int size = q.size();

                for (int i = 0; i < size; i++) {
                    String parent = q.poll();

                    if (parent.equals(endWord)) {
                        return level;
                    }

                    for (String adjacent : adj.get(parent)) {
                        if (!visited.contains(adjacent)) {
                            visited.add(adjacent);
                            q.offer(adjacent);
                        }
                    }
                }

                level++;
            }
            return 0;
          
    }
    public boolean match(String word1, String word2) {
    if (word1.length() != word2.length()) {
        return false;
    }
    int diff = 0;
    for (int i = 0; i < word1.length(); i++) {
        if (word1.charAt(i) != word2.charAt(i)) {
            diff++;
            if (diff > 1) {
                return false;
            }
        }
    }
    return diff == 1;
}    
}