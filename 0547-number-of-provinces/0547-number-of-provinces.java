class Solution {
    int[][] isConnected;
    int[] visited;
      void dfs(int start){
       visited[start]=1;
       for(int  i = 0; i <isConnected[start].length ;i++){
         if(isConnected[start][i]==1  && visited[i]==0){
           dfs(i); 
         }
       }   
      }
    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        this.visited=new int[isConnected.length];
        int count=0;
        for(int i = 0 ; i < isConnected.length ; i++ ){
            if(visited[i]==0){
                count++;
                dfs(i);
            }
        }
        return count;
    }

}