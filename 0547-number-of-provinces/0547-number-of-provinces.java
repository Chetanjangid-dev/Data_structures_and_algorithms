class Solution {
    public void DFS(int node,int[] visited,List<List<Integer>> adj ){
        //jo bhi node aayega wo phle visited mark hoga
        visited[node]=1;
        for (int i=0;i<adj.get(node).size();i++){
            if(visited[adj.get(node).get(i)]==0){
              //mean kya ith city   and hamre current node city  pr conncetion h and wo connected ith node kya univisted h to use visit kro  
              DFS(adj.get(node).get(i),visited,adj);
            }
        }
            return;
    }
    public int findCircleNum(int[][] isConnected) {
     int province=0;
     int[] visited=new int[isConnected.length];
     List<List<Integer>> adj = new ArrayList<>();
     for(int i=0;i<isConnected.length;i++){
        adj.add(new ArrayList<>());
     }
     for (int i=0;i<isConnected.length;i++){
        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j]==1){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
     }  
     for(int i=0;i<isConnected.length;i++){
        if(visited[i]==0){
             province++;
             DFS(i,visited,adj);
        }    
    }
    return province;

    }
}
//here actaully we are acalcuting tot al number of disconncetd graph  that is shown by a maututla adjacecy matrix 
//o(n2) and space o(n)