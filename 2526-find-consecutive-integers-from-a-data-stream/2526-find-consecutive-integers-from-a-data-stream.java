class DataStream {
    class pair{
        int val;
        int freq;
        pair(int val,int freq){
           this.val= val;
           this.freq=freq;
        }
    }
    int target ;
    int k;
    Stack<pair> st ;
    public DataStream(int value, int k) {
        this.target = value;
        this.k = k;
        st= new Stack<>();
    }
    public boolean consec(int num) {
     if(!st.isEmpty() && st.peek().val == target && num == target &&st.peek().freq>=k-1){
        st.peek().freq +=1;
        return true;
     }  
     else if( num == target && k==1)
     {
        st.push(new pair(num,1));
        return true;
     }
     else if(!st.isEmpty() && st.peek().val==num){
        st.peek().freq+=1;
        return false;
     }
     else{
         st.push(new pair(num,1));
         return false;
     }

    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */