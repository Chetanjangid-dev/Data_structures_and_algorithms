class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st =  new Stack();
        st.push(asteroids[0]);
        int i = 1;
        while(i<asteroids.length){
            int curr = asteroids[i];
            if(!st.isEmpty() && st.peek() > 0 && curr<0 ){
                if( st.peek() > Math.abs(curr) ){
                    i++;
                }
                else if(st.peek() < Math.abs(curr)){
                    st.pop();
                }
                else{
                    st.pop();
                    i++;
                }
            }
            else{
                st.push(curr);
                i++;
            }
        }
        int[] ans =  new int[st.size()];
        for(i =0;i<st.size();i++){
            ans[i] =st.get(i);
        }
        return ans;
     }

}