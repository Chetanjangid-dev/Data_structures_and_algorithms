class Solution {
    boolean cycle = false;
    int[] visited;
    HashSet<Integer> path;
      List<List<Integer>> adj;
    private void dfs(int node){
       visited[node]=1;
       for(int neighbour : adj.get(node)){   
        if(path.contains(neighbour)){
            cycle=true;
        }
        else if(visited[neighbour] == 0){
            path.add(node);
            dfs(neighbour);
            path.remove(node);
        }
       }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites){
        this.adj = new ArrayList<>();
        this.visited = new int[numCourses];
        this.path = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int src = edge[1];
            int dest = edge[0];
            adj.get(src).add(dest);
        }
        for(int i=0;i<numCourses;i++){
           if(visited[i] == 0){
            path.add(i);
             dfs(i);
             path.remove(i);
           }
        }        
        return !cycle;
    }
}