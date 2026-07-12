class Solution {
    public void DFS(int[][] isConnected ,int node,int[] visited){
        //jo bhi node aayega wo phle visited mark hoga
        visited[node]=1;
        for (int i=0;i<isConnected[node].length;i++){
            if(isConnected[node][i]==1 && visited[i]==0 ){
              //mean kya ith city   and hamre current node city  pr conncetion h and wo connected ith node kya univisted h to use visit kro  
              DFS(isConnected,i,visited);
            }
        }
            return;
        }

    public int findCircleNum(int[][] isConnected) {
     int province=0;
     int[] visited=new int[isConnected.length];
     for (int i=0;i<isConnected.length;i++){
        //if the node is unvisted inncrement the province beause its diff node from our prev vosted graph
        if(visited[i]==0){
            province++;
           DFS(isConnected,i,visited);
        }
     }  
    return province;     
    }
}