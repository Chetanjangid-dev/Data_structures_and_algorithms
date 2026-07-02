class Solution {
    public int[][] merge(int[][] intervals) {
    ArrayList<int[]> ans = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int i=0;
    while(i<intervals.length){
        //first merge overlapping intervals
        int min=intervals[i][0];
        int max=intervals[i][1];
        while(i+1<intervals.length && max>=intervals[i+1][0]){   
       // 
        max=Math.max(intervals[i+1][1],max);
        i+=1;
        }
        // non overlapping interrvla
        ans.add(new int[]{min, max});
        i++;
    }
    int[][] arr = new int[ans.size()][2];
    for(int j=0;j<ans.size();j++){
        arr[j][0]=ans.get(j)[0];
        arr[j][1]=ans.get(j)[1];
    }
   return arr;
  }
}