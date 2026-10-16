class StockSpanner{
    List<int[]> prev;
    int max=0;
    int count=0;
    public StockSpanner() {
        this.prev =  new ArrayList<>();
        prev.add(new int[]{0,1});
    }
    public int next(int price) {
        count++;
        if(price<max){
           prev.add(new int[]{max,count});
        }
        max=price;
        int i = prev.size()-1;
        int ans=0;
        while(i>=0 && prev.get(i)[0]<=price){
          i--;
        }
        if(i==-1) return count;
        ans = count-prev.get(i)[1]+1;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */