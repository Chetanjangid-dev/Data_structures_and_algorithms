class StockSpanner{
    List<Integer> days ;
    public StockSpanner() {
        this.days =  new ArrayList<>();
    }
    public int next(int price) {
       days.add(price);
       int count = 0;
       int i = days.size()-1;
       while(i>=0 && days.get(i)<=price){
        count++;
        i--;
       }
       return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */