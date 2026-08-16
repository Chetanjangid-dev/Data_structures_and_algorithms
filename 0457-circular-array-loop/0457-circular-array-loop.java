class Solution {
    HashSet<Integer> visited;
    int[] nums;
    public boolean formacycle(int start,boolean allpos){
       HashSet<Integer> curr = new HashSet<>();
       if(nums[start]==0){
            visited.add(start);
            return false;//this is cycle len 1  and we are makeing valid cycle pos or neg based on the satrting point of cycle if it 
            //is 0 it becomes tie we cant decide if all cycle shoud pos oor nneg just ignore we evn w=cnat move from the index 
            //so it can consdiered as a  cycle len=1 thats invlaid
        }
        //the real issue i wnat tp get realc cylce len
       int i = start;
       int cycle_len=0;
       boolean isvalid = true;//bcz the first elemnt of cyclee  reseptcively have  valid cycle 
       while(!curr.contains(i)){
        curr.add(i);
        i = ((i + nums[i] % nums.length)+nums.length)%nums.length;// next move
       // cycle_len++;
       }
       if(visited.contains(i)){
        return false;
       }
       for (int x : curr) {
          visited.add(x);
        }
       //bc jha me whaps aa agya whi ctuak cycle starying point h //so i gain starttrversing it to see the len
       HashSet<Integer> temp =  new HashSet<>();
       allpos=nums[i]>0;
       while(!temp.contains(i)){
           if((nums[i]<0 &&  allpos==true)  || (nums[i] > 0 && allpos==false) ){
            isvalid = false;
           }
           temp.add(i);
           i = ((i + nums[i] % nums.length)+nums.length)%nums.length;// next move          
           cycle_len++;
       }
       return isvalid && (cycle_len>1);
     }
    public boolean circularArrayLoop(int[] nums) {
       this.visited =  new HashSet<>();
       this.nums=nums;
       for(int i = 0 ; i < nums.length ;i++){
        if(!visited.contains(i)){
            if(formacycle(i,nums[i]>0)){
                return true;
            }
        }
       } 
       return  false; 
    }
}