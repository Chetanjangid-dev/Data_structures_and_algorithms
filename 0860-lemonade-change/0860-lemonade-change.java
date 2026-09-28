class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five$ = 0;
        int ten$ = 0;
        int twenty$ = 0;
        int total =0;
        int i = 0;
        while(i<bills.length){
           int bill = bills[i];
           if(bill==5){
            five$++;
           }
           else if(bill==10){
             if(five$>0){
                ten$++;
                five$--;
             }
             else{
                return false;
             }
           }
           else{
                    if(five$ > 0 && ten$>0){
                        five$--;
                        ten$--;
                        twenty$++;
                    }
                    else if(five$>=3){
                        five$-=3;
                        twenty$++;
                    }
                    else {
                        return false;
                    }
            }
        i++;
        }
        return true;
    }
}