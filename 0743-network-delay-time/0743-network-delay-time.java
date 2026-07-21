class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
   List<List<List<Integer>>> adj = new ArrayList<>();
   for (int i = 0; i <= n; i++) {
    adj.add(new ArrayList<>());
   }
   for (int i = 0; i < times.length; i++) {
     int u = times[i][0];
     int v = times[i][1];
     int w = times[i][2];
     List<Integer> edge = new ArrayList<>();
     edge.add(v);
     edge.add(w);
     adj.get(u).add(edge);
     }
     int[] min_time=new int[n+1];
     Arrays.fill(min_time, Integer.MAX_VALUE);
     PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
     q.offer(new int[]{k,0});
     min_time[k]=0;
     while(!q.isEmpty()){
        int[] pair=q.poll();
        int node = pair[0];
         int time = pair[1];
        if (time > min_time[node]){ continue;}
        for(int i=0;i<adj.get(node).size();i++){
            List<Integer> adjacent_pair = adj.get(node).get(i);
            int adjacent=adjacent_pair.get(0);
            int adjacent_time=adjacent_pair.get(1);
            if(adjacent_time+time<min_time[adjacent]){
                min_time[adjacent]=adjacent_time + time;
                q.offer(new int[]{adjacent,min_time[adjacent]});
            }
        }
     }
     for(int i=1;i<min_time.length;i++){
        if(min_time[i]==Integer.MAX_VALUE){// koi node infinte distnace pr bcha h even after dijkstras k bad ntlb wo node unreachbe h
        return -1;
        }
     }
     //we have calcualted the minn time to reach the network ffrom sourceevnodes to another nodes  nnow the npde on which time is ma taken compares to other nodes will deifne the total min time beacuse under this time all the nodes get the newtwork due to parallel processing pf time and after the max time node gte rhe newtok all node have network now 
     int time=0;
     for(int i=1;i<min_time.length;i++){
         time=Math.max(time,min_time[i]);
     }
     return time;
    }
}