class Solution {
    public int minSwaps(String s) {
      Stack<Character> stack =  new Stack();
      int close_to_open = 0, open_to_close=0 ,swaps=0,fi=0,se=1;
      for(int  i = 0 ;i<s.length();i++){
        if(!stack.isEmpty() && stack.peek() == '[' && s.charAt(i)==']' ){
          stack.pop();
        }
        else{
          stack.push(s.charAt(i));
        }
      }     
      while(fi<stack.size()-1 && se <stack.size()){
        if(stack.get(fi) == '[' && stack.get(se) == '[' ){
             if(open_to_close<=0){
                close_to_open++;
                swaps++;
             }
             else{
                open_to_close--;
             }
        }
        else if(stack.get(fi) == ']' && stack.get(se) == ']'){
             if(close_to_open<=0){
                open_to_close++;
                swaps++;
             }
             else{
                close_to_open--;
             }
        }
        else{
           if(open_to_close > 0 && close_to_open > 0){
              open_to_close--;
              close_to_open--;
           }
           else {
               swaps++;
           }
        }
        fi=fi+2;
        se=se+2;
      }
      return swaps;
    }
}