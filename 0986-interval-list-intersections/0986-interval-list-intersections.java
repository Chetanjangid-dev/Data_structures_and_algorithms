class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int first=0;
        int  second=0;
         ArrayList<int[]> ans = new ArrayList<>();
        while(first<firstList.length && second<secondList.length){
            int min=Math.max(firstList[first][0] , secondList[second][0]);
            int max=Math.min(firstList[first][1] , secondList[second][1]);
            if(max>=min){
              ans.add(new int[]{min,max});  
            } 
            if(secondList[second][1]>firstList[first][1]){
                first+=1;
            }
            else{
                second+=1;
            }
          }
           int[][] arr = new int[ans.size()][2];
           for(int j=0;j<ans.size();j++){
            arr[j][0]=ans.get(j)[0];
            arr[j][1]=ans.get(j)[1];
            }
        return arr;
    }
}