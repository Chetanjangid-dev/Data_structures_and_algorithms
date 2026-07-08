import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
     int n = profits.length;
     int p=0;
     int  completed=0;
     int[][] projects = new int[n][2];
            for (int i = 0; i < n; i++) {
                projects[i][0] = capital[i];
                 projects[i][1] = profits[i];
            }
            Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
            PriorityQueue<int[]> h = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1])
             );
    
     while(completed!=k){
       while(p<projects.length && w>=projects[p][0]){
          h.offer(new int[]{projects[p][0],projects[p][1]});
          p++;
       }
       if(h.isEmpty()==true){break;}
        w+=h.poll()[1];
        completed++;
     } 
     return w;
    }
}