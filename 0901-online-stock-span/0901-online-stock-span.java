class StockSpanner{
    List<int[]> days;
    int prev,count;
    Stack<int[]> stack ;
    public StockSpanner() {
        this.count = 0;
        this.stack =  new Stack();
        this.prev = Integer.MAX_VALUE;
    }
    public int next(int price) {
        count++;
        if(price<prev){
            stack.push(new int[]{count-1,prev});
            prev = price;
            return 1;
        }  
        while(!stack.isEmpty() && stack.peek()[1] <= price){
            stack.pop();
        }
        int ans = count-stack.peek()[0];
        stack.push(new int[]{count,price});
        return ans; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */