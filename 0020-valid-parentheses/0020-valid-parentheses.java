import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public boolean isValid(String s) {
         Deque<Character> stack = new ArrayDeque<>();
         HashMap<Character ,Character> map = new HashMap<>();
         map.put(')','(');
         map.put('}','{');
         map.put(']','[');
         int n =  s.length();
         int i = 0;
         HashSet<Character>  open =  new HashSet<>();
         open.add('(');
         open.add('{');
         open.add('[');
         while(i < n ){
            char curr = s.charAt(i);
            if(stack.isEmpty() || open.contains(curr)){
                stack.push(curr);
            }
            else{
                if(!stack.isEmpty() && map.get(curr) == stack.peek()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            i++;
         }
         return stack.size()==0;
    }
}