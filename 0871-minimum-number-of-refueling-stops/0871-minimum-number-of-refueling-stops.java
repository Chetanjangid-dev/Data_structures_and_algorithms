class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
       PriorityQueue<int[]> h = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
       int stops=0;
       int p=0;
       int currentfuel=startFuel;
       while(target>currentfuel){
           //explore the reachable stops 
         while( p<stations.length && stations[p][0]<=currentfuel){
            h.offer(new int[]{stations[p][0], stations[p][1]});
             p++;
         }
         //now i will check if still i dont ahve even any station reachbele
         if(h.isEmpty()==true && currentfuel<target){
            return -1;
         }
         //means i ahve reachble stations;
         int[] stop=h.poll();
         currentfuel+=stop[1]; //treasuyry from there
         stops++;
       }
       return stops;
    }
}






