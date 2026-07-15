class Solution {
    int node;
    int[] visited;
    Queue<Integer> q ;
    public void bfs(int[][] graph){
         while(!q.isEmpty()){
          node=q.poll();
          for(int i=0;i<graph[node].length;i++){
            if(visited[graph[node][i]]==0){
                if(visited[node]==1){
                    visited[graph[node][i]] =2;
                }
                else{
                     visited[graph[node][i]] =1;
                }
                q.offer(graph[node][i]);
            }
          }
        } 
    }
    public boolean isBipartite(int[][] graph) {
        visited=new int[graph.length];
        q = new ArrayDeque<>();
        for(int i=0;i<graph.length;i++){
          if(visited[i]==0){
          q.offer(i);//intiail
          visited[i]=1;// 0 shows not vivted while 1 shows visted and red and 2- shpws yellow and visted     
          bfs(graph);
          }
        }
     // now check for bipartitiness
     for(int i=0;i<graph.length;i++){
        for(int j=0;j<graph[i].length;j++){
            if(visited[graph[i][j]]==visited[i]){
               System.out.println(visited[graph[i][j]] + " " + visited[i]);
                return false;
            }
        }
     }
     return true;
    }
}