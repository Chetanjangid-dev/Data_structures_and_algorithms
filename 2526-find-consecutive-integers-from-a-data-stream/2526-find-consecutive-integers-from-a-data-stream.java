class DataStream {
    int count;
    int target ;
    int k;
    public DataStream(int value, int k) {
        this.target =value;
        this.k =k;
        this.count=0;
    }
    
    public boolean consec(int num) {
        if(num==target) count++;
        else if(num!=target) count=0;
        return count>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */