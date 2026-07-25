class Node {
    String word;
    int level;
    Node(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        if(!wordList.contains(endWord)){return 0;}
        String parent,adjacent;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(beginWord, 1));
        dict.remove(beginWord);
        while(!q.isEmpty()){
           Node pair=q.poll();
           parent=pair.word;
           int level=pair.level;
           StringBuilder sb = new StringBuilder(parent);
           for(int i=0;i<parent.length();i++){
               char changed=parent.charAt(i);
               for(int j=97;j<123;j++){
                  sb.setCharAt(i,(char) j);
                  adjacent = sb.toString();
                  if(adjacent.equals(endWord)){
                    return level+1;
                  }
                  if(dict.contains(adjacent)){
                      q.offer(new Node(adjacent,(level+1)));  
                      dict.remove(adjacent);                 
                  }
               }
               sb.setCharAt(i,changed);
           }
        }
        return 0;
    }
}