class pair{
    String word;
    int lvl;
    pair(String word,int lvl){
       this.word=word;
       this.lvl=lvl;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     Set<String>  set  =  new HashSet<>(wordList);
     if(!set.contains(endWord)) return 0;
     Queue<pair> q =  new ArrayDeque<>();
     q.add(new pair(beginWord,1));
     while(!q.isEmpty()){
        pair  p =  q.poll();
        String word = p.word;
        int lvl  = p.lvl;
        
        StringBuilder sb =  new StringBuilder(word);
        for(int  i = 0 ; i <sb.length();i++){
            char original = sb.charAt(i);  
            for(int j =97 ;j<123;j++){
               sb.setCharAt(i,(char)j);
               String child = sb.toString();
               if(set.contains(child)){
                 set.remove(child);
                 if(child.equals(endWord)){
                    return lvl+1;
                 }
                 q.offer(new pair(child,lvl+1));
               }   
            } 
            sb.setCharAt(i,original);
        }
     }
     //agrvyha tk bhi word form nhi hua mmtb endowrd l lssut me to h but strting from our startword  we arent reach to endword 
     return 0;
    }
}