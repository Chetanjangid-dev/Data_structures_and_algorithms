class Solution {
    public int[] countBits(int n) {
        int[] ans =  new int[n+1];
        for(int   i = 1 ;  i <=n ;i++){
          ans[i] = ans[i>>1] +(i&1) ; //i>>1 i int ki binry repr me 1 nit right to left shift krta h  and jo binry repr bnti wi int me conver thi jati and ans[i>>1] hume ek right shifr krne se jo int mila h usme kktine bits h ye btata h and ifr i&1 return 1 if the last bit is 1 and return false if the last bit is 0  so we can know ki jo hummen last bit remove ki thi wo 1 thi ya zwer ot tkai hum actaull 1 ka count i ki binty repr me kitne h ye stor ekr payte ams[i] me   
        }
        return ans;
    }
}