class Router {
    Deque <int[]> queue;
    int memorylimit;
    HashSet<String> packets;
    HashMap<Integer,List<Integer>> ranges;
    public Router(int memoryLimit) {
        this.queue =  new ArrayDeque();
        this.memorylimit =  memoryLimit;
        this.packets = new HashSet<>();
        this.ranges =  new HashMap<>();
    }
    public boolean addPacket(int source, int destination, int timestamp) {
      String key = source+"#"+destination+"#"+timestamp;
     if(packets.contains(key)) return false;
     int[] newpacket =  new int[]{source,destination,timestamp};     
     if(queue.size() < memorylimit){
        queue.offer(newpacket);
     } 
     else{
     int[] packet  = queue.poll(); 
     packets.remove(packet[0]+"#"+packet[1]+"#"+packet[2]);
      List<Integer> curr =  ranges.get(packet[1]);
        ranges.get(packet[1]).remove(0);
        if(ranges.get(packet[1]).size()==0){
            ranges.remove(packet[1]);
        }
     queue.offer(newpacket); 
     }
     if(ranges.containsKey(destination)){
        ranges.get(destination).add(timestamp);
     }
     else{
        List<Integer> temp =  new ArrayList<>();
        temp.add(timestamp);
        ranges.put(destination,temp);
     }
     packets.add(key);
     return true;
    }
    
    public int[] forwardPacket() {
     if(queue.size()>0) {
        int[] packet = queue.poll();
        String key = packet[0]+"#"+packet[1]+"#"+packet[2];
        ranges.get(packet[1]).remove(0);
        if(ranges.get(packet[1]).size()==0){
            ranges.remove(packet[1]);
        }
        packets.remove(key);
        return packet;
     }
     return new int[]{};        
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(queue.size()==0 || queue.getLast()[2] < startTime || queue.peek()[2] > endTime || !ranges.containsKey(destination)) return 0;
        
        int count = 0;
        List<Integer> curr =  ranges.get(destination);
        int low = 0 ;
        int high = curr.size()-1;
        if(curr.get(low)>endTime || curr.get(high) <startTime) return 0; 
        int first=-1,second=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(curr.get(mid)>=startTime){
                first = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(first == -1) return 0;
        low=0;
        high = curr.size()-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(curr.get(mid)<=endTime){
                 second = mid;
                 low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        if(second<first) return 0;
        count = second-first+1;
        return count;
    }

}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */