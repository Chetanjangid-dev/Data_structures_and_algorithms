class Solution {  
    public String removeKdigits(String num, int k){
        if( k== 0 || num =="" ) return num;
        if(num.length() == k) return "0";
        Stack <Integer> st =  new Stack();
        int  i = 0;
        while(i<num.length()){
            int n = Integer.parseInt(num.charAt(i)+"");
            while(!st.isEmpty() && st.peek() > n && k>0 ){
                st.pop();
                k--;
            }
            st.push(n);
            i++;
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb =  new StringBuilder();
        boolean posfound = false;
        for(int j : st){
               sb.append(j+"");
        }
        String m =  sb.toString();
        if(m.length()== 0 && m.charAt(0) == 0){
            return "0";
        }
          i  =0;
        while(i<m.length()-1){
            if(m.charAt(i) != '0' && posfound == false){
              break;
            }
            i++;
        }
        return m.substring(i,m.length());

    }
}