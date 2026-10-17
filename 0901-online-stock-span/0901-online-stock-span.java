class StockSpanner{
    List<int[]> days;
    int prev,count;
    public StockSpanner() {
        this.count = 0;
        this.prev = Integer.MAX_VALUE;
        this.days =  new ArrayList<>();
        days.add(new int[]{0,prev});
    }
    public int next(int price) {
        count++;
        if(price<prev){
           days.add(new int[]{count-1,prev});
           prev = price;
           return 1;
        }
        prev = price;
        int i = days.size()-1;
        while(i>=0 && days.get(i)[1]<=price){
          i--;
        }
        return count-days.get(i)[0];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */