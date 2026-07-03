import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public boolean isValid(String s) {
         Deque<Character> stack = new ArrayDeque<>();
         HashMap<Character ,Character> map = new HashMap<>();
         map.put(')','(');
         map.put('}','{');
         map.put(']','[');

         for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' ||  s.charAt(i)=='{'  ||  s.charAt(i)=='['  ){
                stack.push(s.charAt(i));
            }
            else{
                if ( stack.isEmpty()  || stack.peek()!=map.get(s.charAt(i)) ){
                    return false;
                }
                   stack.pop();
            }
         }
         return stack.size()==0;
    }
}