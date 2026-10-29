class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int taskcompleted = 0;
        int[] indegree =  new int[numCourses];
        Queue<Integer> q =  new ArrayDeque();
        List<List<Integer>> dependency = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            dependency.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int src = edge[1];
            int dest = edge[0];
             indegree[dest]++;
            dependency.get(src).add(dest);
        }
        for(int i =0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
             
        }
        while(!q.isEmpty()){
            int ele = q.poll();
            taskcompleted++;
            for(int neigh : dependency.get(ele)){
              indegree[neigh]--;
              if(indegree[neigh] == 0){
                q.offer(neigh);
              }
            }
        }
        return taskcompleted == numCourses;
    }
}