class Solution {
    public int rob(int[] nums) {
     int[] dp=new int[nums.length+1];
     dp[nums.length]=0;//bcz in rec if(i>=nums.lenngth){return 0}//a=yani  agr me bounds ko par kr gya to lgicallly i cn loot 0 money 
     dp[nums.length-1]=nums[nums.length-1]; // mtlb agr i==nums.length-1 then answr is value at curr index of nums genraalyy agr last index pr hu to me us index pr jo hghr h usi ki money loot skta hu agr take skip me se max le to us index ppr jo value h wo ans hoga
     for(int i=nums.length-2;i>=0;i--){
        dp[i]=Math.max((nums[i]+dp[i+2]),dp[i+1]);
     }
     return dp[0];
    }
}