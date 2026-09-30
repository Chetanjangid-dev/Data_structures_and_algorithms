class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0 ;
        while(numBottles>=numExchange){
          ans+=numBottles  -(numBottles%numExchange);//jin bottle ko me nummexhnage k goupe me nhi la skat unhe mecurently consume nhi kurnha becse we will cant get a fileed bottles from them so keep the as its  filled and when later yu get new filled bittle sin ehcnsg of our prev bottle s then try to grp them with it
          numBottles=(numBottles/numExchange) + (numBottles%numExchange);//jin bttoesl ko consume nhi kiya tha wo bhi filled hi rhegi
        }
        //end jb last me hamre pss jin botle ko gro nhi  kr sskte to get a new bottle bchegi to humbhci hui bittles bho counse mr krlenge
        return ans+numBottles;
    }
}