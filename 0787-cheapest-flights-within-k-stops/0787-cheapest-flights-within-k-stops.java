class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int[] dist=new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[src]=0;
      for(int i=0;i<=k;i++){
         int[] temp = dist.clone();
        for(int j=0;j<flights.length;j++){
          int[] pair=flights[j];
          int s=pair[0];
          int d=pair[1];
          int w=pair[2];
          if((long)dist[s]+w<(long)temp[d]){
            temp[d]=dist[s]+w;
          }
        }
        dist=temp;
      }
     if(dist[dst] == Integer.MAX_VALUE){ return -1;}
     return dist[dst];
    }  
}