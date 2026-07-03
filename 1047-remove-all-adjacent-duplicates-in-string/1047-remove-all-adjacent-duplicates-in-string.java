import java.util.ArrayDeque;
import java.util.Deque;
//implemnting stack using deque bcs its faster
class Solution {
    public String removeDuplicates(String s) {
       Deque<Character> stack = new ArrayDeque<>();
       for(int i=s.length()-1;i>=0;i--){
        //when to insert
        if(stack.isEmpty() || stack.peek()!=s.charAt(i)){
         stack.push(s.charAt(i));    
        }
        else{
            stack.pop();
        }
       }
       StringBuilder sb = new StringBuilder(); 
 
     while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
 
    String result = sb.toString();
      return result;
    }
}