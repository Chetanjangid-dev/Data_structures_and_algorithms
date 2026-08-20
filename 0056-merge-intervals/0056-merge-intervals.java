class Solution {
    public int[][] merge(int[][] intervals) {
     Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
     int i = 0;
     int start ;
     int end;
     List<List<Integer>> ans =  new ArrayList<>();
     while(i<intervals.length){
       start = intervals[i][0];
       end = intervals[i][1];
       while(i+1<intervals.length && end >= intervals[i+1][0]){
          start = Math.min(start,intervals[i+1][0]);
          end = Math.max(end,intervals[i+1][1]);
          i++;
       }
       List<Integer> temp =  new ArrayList<>();
       temp.add(start);
       temp.add(end);
       ans.add(temp);
       i++;
     }
   
int[][] arr = new int[ans.size()][];

for (int k = 0; k < ans.size(); k++) {
    arr[k] = new int[ans.get(k).size()];

    for (int j = 0; j < ans.get(k).size(); j++) {
        arr[k][j] = ans.get(k).get(j);
    }
}
     return arr;       
    }
}