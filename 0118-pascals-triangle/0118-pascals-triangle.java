class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans =  new ArrayList<>();
       for(int  i = 0 ;i<numRows ;i++){
          List<Integer> list = Arrays.asList(new Integer[i+1]);
          list.set(0,1);
          list.set(list.size()-1,1);
          ans.add(list);
       }
       for(int  i = 2;i<ans.size();i++){
           for(int j =1;j<ans.get(i).size()-1;j++){
             ans.get(i).set(j,(int)ans.get(i-1).get(j-1) +(int)ans.get(i-1).get(j));
           }
       }
       return ans;
    }
}