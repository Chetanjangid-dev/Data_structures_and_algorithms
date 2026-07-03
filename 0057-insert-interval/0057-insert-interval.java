class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
   // 3 parts
    ArrayList<int[]> ans = new ArrayList<>();
   int start=newInterval[0];
   int end=newInterval[1];
   int n=intervals.length;
   int i=0;
   while(i<n && intervals[i][1] < start){
     ans.add(new int[]{intervals[i][0],intervals[i][1]});
     i+=1;
   }
   while(i<n && intervals[i][0] <=end){
     start=Math.min(start,intervals[i][0]);
     end=Math.max(end,intervals[i][1]);
     i+=1;
   }
   ans.add(new int[]{start,end});
   while(i<n){
     ans.add(new int[]{intervals[i][0],intervals[i][1]});
     i+=1;
   } 
   int[][] arr = new int[ans.size()][2];
    for(int j=0;j<ans.size();j++){
        arr[j][0]=ans.get(j)[0];
        arr[j][1]=ans.get(j)[1];
    }
   return arr;
}
}