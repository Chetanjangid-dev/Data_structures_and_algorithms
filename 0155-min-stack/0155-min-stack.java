class MinStack {
    List<int[]> st;
    int min ;
    public MinStack() {
        this.min=Integer.MAX_VALUE;
        this.st= new ArrayList<>();
    }
    public void push(int value) {
        min = Math.min(min,value);
        st.add(new int[]{min,value});
    }
    public void pop() {
            st.remove(st.size()-1);
            if(st.size()>0)
              min =  st.get(st.size()-1)[0];
            else 
              min = Integer.MAX_VALUE;
    }
    public int top() {
        return st.get(st.size()-1)[1];
    }
    public int getMin(){
        return st.get(st.size()-1)[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */